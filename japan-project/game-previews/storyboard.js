const storyboardVersion=new URL(document.currentScript.src).search;
const storyboardBase=new URL('provided/',document.currentScript.src);
const boardDialog=document.createElement('dialog');
boardDialog.className='board-popup';
boardDialog.setAttribute('aria-label','게임 시나리오보드와 플레이 목업');
boardDialog.innerHTML='<header><strong></strong><div><button type="button" class="popup-board">시나리오보드</button><button type="button" class="popup-play">목업 직접 눌러보기 →</button><button type="button" class="popup-close" aria-label="팝업 닫기">✕</button></div></header><div class="popup-content"></div>';
document.body.append(boardDialog);
let popupBase;
function endingFork(base){return '<span class="ending-fork"><span class="ending-fork-heading">14일의 선택 → 서로 다른 엔딩 <small>결말 예시 · 본편에 모두 포함</small></span><span class="ending-paths"><span><img src="'+new URL('img/avatar.jpg',base).href+'" alt="연인 동거 엔딩 예시"><span><small>일상·애정을 쌓으면 ↘</small><b>연인으로 계속 동거</b><em>“내일도 여기서, 너와 함께.”</em></span></span><span><img src="'+new URL('img/scene_beach.jpg',base).href+'" alt="여행 엔딩 예시"><span><small>외출·약속을 쌓으면 ↙</small><b>둘만의 여행</b><em>“다음 추억은, 우리 밖에서 만들자.”</em></span></span></span><span class="ending-replay">다른 선택으로 다시 플레이 → 다른 엔딩·추억 앨범 수집</span></span>';}

function showPopup(mode){
 const content=boardDialog.querySelector('.popup-content');
 boardDialog.classList.toggle('playing',mode==='play');
 boardDialog.querySelector('.popup-board').hidden=mode!=='play';
 boardDialog.querySelector('.popup-play').hidden=mode==='play';
 content.replaceChildren();
 content.classList.toggle('with-endings',popupBase.pathname.endsWith('/g22/')&&mode==='board');
 if(mode==='play'){const frame=document.createElement('iframe');frame.src=new URL('mockup.html'+storyboardVersion,popupBase);frame.title='게임 목업 직접 플레이';content.append(frame);}
 else{const image=document.createElement('img');image.src=new URL('storyboard.png',popupBase);image.alt='전체 플레이 흐름 · 6장면';content.append(image);if(popupBase.pathname.endsWith('/g22/')){const fork=document.createElement('div');fork.innerHTML=endingFork(popupBase);content.append(fork);}}
 if(!boardDialog.open)boardDialog.showModal();
}
boardDialog.querySelector('.popup-close').onclick=()=>boardDialog.close();
boardDialog.querySelector('.popup-play').onclick=()=>showPopup('play');
boardDialog.querySelector('.popup-board').onclick=()=>showPopup('board');
boardDialog.addEventListener('close',()=>boardDialog.querySelector('.popup-content').replaceChildren());
boardDialog.addEventListener('click',event=>{const r=boardDialog.getBoundingClientRect();if(event.target===boardDialog&&(event.clientX<r.left||event.clientX>r.right||event.clientY<r.top||event.clientY>r.bottom))boardDialog.close();});
function drawBoard(root,id){
 if(!/^g2[1-5]$/.test(id))id='g21';
 const base=new URL(id+'/',storyboardBase);
 root.innerHTML='<div class="zip-storyboard"><button type="button" class="zip-overview" aria-label="전체 시나리오보드 크게 보기"><img src="'+new URL('storyboard.png',base).href+'" alt="전체 플레이 흐름 · 6장면">'+(id==='g22'?endingFork(base):'')+'</button><p class="zip-play"><span>보드를 누르면 크게 볼 수 있습니다.</span><a href="'+new URL('mockup.html'+storyboardVersion,base).href+'">목업 직접 눌러보기 →</a></p></div>';
 function open(mode){popupBase=base;boardDialog.querySelector('header strong').textContent=root.getAttribute('aria-label')||'게임 시나리오보드';showPopup(mode);}
 root.querySelector('.zip-overview').onclick=()=>open('board');
 root.querySelector('.zip-play a').onclick=event=>{event.preventDefault();open('play');};
}
for(const root of document.querySelectorAll('[data-storyboard-game]'))drawBoard(root,root.dataset.storyboardGame);
const single=document.getElementById('storyboard');if(single)drawBoard(single,new URLSearchParams(location.search).get('game')||'g21');
