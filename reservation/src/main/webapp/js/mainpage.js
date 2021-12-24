window.addEventListener("DOMContentLoaded", initialize);

function initialize() {
	renderPromotionCarousel();	
	renderCategories();
	renderMoreProducts(0);
}


function renderPromotionCarousel() {
	const promotionContainer = document.querySelector('.visual_img');
	
	httpRequest('GET', '/promotions', response => {	
		renderPromotionImages(JSON.parse(response).promotions);
		rotatePromotion();	
	});
	
	function renderPromotionImages(promotions) {
		const promotionTemplate = document.getElementById('promotionItem').innerText;
		promotionContainer.innerHTML = promotions.map(({ id, productImageUrl, title, placeName, description }) => (
			promotionTemplate.replace("{id}", id)
							 .replace("{productImageUrl}", productImageUrl)
							 .replace("{title}", title)
							 .replace("{placeName}", placeName)
							 .replace("{description}", description)
		)).join('');
	}
}

function rotatePromotion() {
	const promotion = document.querySelector('.visual_img');
	const firstItemClone = promotion.firstElementChild.cloneNode(true);
	promotion.appendChild(firstItemClone);
	
	const promotionCount = promotion.children.length;
	const movingDistance = promotion.firstElementChild.offsetWidth;
	let promotionIndex = 0;
	
	setInterval(function() {
		promotion.style.transition = '0.2s';
		promotion.style.transform = "translateX(-" + promotionIndex * movingDistance + "px";
		
		promotionIndex++;
		
		if(promotionIndex === promotionCount) {
			setTimeout(function() {
				promotion.style.transition = '0s';
				promotion.style.transform = "translateX(0px)";
			}, 201);
			promotionIndex = 1;					
		}
	}, 2000);
}

function renderCategories() {
	const categoryContainer = document.querySelector('.event_tab_lst.tab_lst_min');
	let activatedTabIndex = 0;
	
	httpRequest('GET', '/categories', response => {
		renderCategoryTabs(JSON.parse(response).categories);
		activateTab(0);
		renderProducts(0);
		categoryContainer.addEventListener('click', onClickCategoryTabs);
	});
	
	function renderCategoryTabs(categories) {
		const categoriesWithTotal = [
			{ id: 0, name: "전체 리스트" },
			...categories
		];
		categoryContainer.innerHTML += categoriesWithTotal.map(({ id, name }) =>(
			`<li class="item" data-categoryid="${id}">
            	<a class="anchor"> 
					<span>${name}</span> 
				</a>
            </li>`
		)).join('');
	}
	
	function onClickCategoryTabs(event) {
		const li = event.target.closest('li');
		const categoryId = parseInt(li.dataset.categoryid);
		
		showMoreButton();
		activateTab(categoryId);
		clearProducts();
		renderProducts();
		
		function clearProducts() {
			const displayItemContainers = document.querySelectorAll('.lst_event_box'); 
			displayItemContainers.forEach(ul => ul.innerHTML = '');
		}
	}
	
	function activateTab(categoryId) {
		categoryContainer.children[activatedTabIndex].firstElementChild.classList.remove('active');
		activatedTabIndex = categoryId;
		categoryContainer.children[activatedTabIndex].firstElementChild.classList.add('active');			 
	}	
}

function updateDisplayInfoCount(totalCount) {
	const eventText = document.querySelector('.event_lst_txt');
	eventText.innerHTML = `
		바로 예매 가능한 행사가 <span class="pink">${totalCount}개</span> 있습니다.
	`;
}

function renderProducts(start = 0) {
	const categoryId = parseInt(document.querySelector('.anchor.active').parentElement.dataset.categoryid);
	
	httpRequest('GET', `/products?categoryId=${categoryId}&start=${start}`, response => {
		const { totalCount, products } = JSON.parse(response);
		updateDisplayInfoCount(totalCount);	
		renderDisplayItems(products);
	});
	
	function renderDisplayItems(products) {
		const itemListTemplate = document.getElementById('itemList').innerText;
		const displayItemContainers = document.querySelectorAll('.lst_event_box');
		
		products.forEach(({  
			productId,
			productDescription, 
			placeName, 
			productContent, 
			productImageUrl 
		}, index) => {
			displayItemContainers[index % 2].innerHTML += itemListTemplate
				.replace(/\{id\}/g, productId)
				.replace(/\{productDescription\}/g, productDescription)
				.replace("{productImageUrl}", productImageUrl)
				.replace("{placeName}", placeName)
				.replace("{productContent}", productContent);
		});
	}
}

function renderMoreProducts() {
	const buttonToGetMoreProducts = document.querySelector('.more > .btn');
	
	onClickMoreButton();

	function onClickHandler() {
		const totalCount = parseInt(document.querySelector('.event_lst_txt .pink').textContent);
		const productCount = document.querySelectorAll('.lst_event_box .item').length;
				
		if(productCount < totalCount) {
			renderProducts(productCount);	
		}
		if(productCount + 4 >= totalCount) {
			hideMoreButton();
		}
	}
	
	function onClickMoreButton() {
		buttonToGetMoreProducts.addEventListener('click', onClickHandler);
	}
	
}

function showMoreButton() {
	const buttonToGetMoreProducts = document.querySelector('.more > .btn');
	buttonToGetMoreProducts.style.display = '';		
}

function hideMoreButton() {
	const buttonToGetMoreProducts = document.querySelector('.more > .btn');
	buttonToGetMoreProducts.style.display = 'none';
}