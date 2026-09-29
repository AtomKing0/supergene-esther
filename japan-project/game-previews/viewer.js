/* One native dialog serves all boards; the existing game runtime owns play state. */
(() => {
 const scriptURL=new URL(document.currentScript.src),base=new URL('.',scriptURL);
 const version=scriptURL.searchParams.get('v')||'dev';
 const dialog=document.createElement('dialog');
 dialog.className='flow-viewer';dialog.setAttribute('aria-labelledby','viewer-title');
 dialog.innerHTML='<header class="viewer-head"><div><small>플레이 흐름</small><h2 id="viewer-title"></h2></div><button type="button" data-viewer="close" aria-label="크게 보기 닫기">닫기 ×</button></header><div class="viewer-toolbar"><div class="viewer-modes" aria-label="보기 방식"><button type="button" data-viewer="view">장면 설명</button><button type="button" data-viewer="play">직접 플레이</button></div><div class="viewer-controls"><button type="button" data-viewer="auto" aria-pressed="false">▶ 자동 재생</button><label>속도 <select aria-label="자동 재생 간격"><option value="5000">5초</option><option value="3000">3초</option><option value="8000">8초</option></select></label><button type="button" data-viewer="reset">처음부터</button></div></div><div class="viewer-arena"><div class="detail-fit"><section class="storyboard-mode" id="viewer-scene"></section></div><iframe title="게임 직접 플레이 목업" hidden></iframe></div><footer class="viewer-bottom"><div class="viewer-navigation"><button type="button" data-viewer="prev" aria-label="이전 장면">←</button><div class="viewer-steps" aria-label="장면 이동"></div><button type="button" data-viewer="next" aria-label="다음 장면">→</button></div><p class="viewer-status" role="status" aria-live="polite"></p><small>제안용 목업 · 고정 대화 · 실제 결제 없음</small></footer>';
 document.body.append(dialog);
 const q=s=>dialog.querySelector(s),frame=q('iframe'),stage=q('#viewer-scene'),fit=q('.detail-fit');
 let active=null,scene=0,mode='view',timer=null,opener=null,previousOverflow='',ready=false,playFinished=false;
 function stop(){clearTimeout(timer);timer=null;q('[data-viewer="auto"]').textContent='▶ 자동 재생';q('[data-viewer="auto"]').setAttribute('aria-pressed','false');}
 function send(command){if(ready)frame.contentWindow.postMessage({type:'flow-control',command},location.origin==='null'?'*':location.origin);}
 function status(text){q('.viewer-status').textContent=text;}
 function fitScene(){if(!dialog.open||mode!=='view')return;const width=fit.clientWidth<620?360:Math.min(960,fit.clientWidth);stage.style.width=width+'px';stage.classList.toggle('portrait-detail',width===360);const scale=Math.min(1,fit.clientWidth/width,fit.clientHeight/stage.offsetHeight);stage.style.transform='translate(-50%,-50%) scale('+scale+')';}
 function draw(){
  const game=games[active],plan=screenPlans[active][scene];
  stage.className='storyboard-mode detail-stage '+game.theme;
  stage.innerHTML='<header class="detail-heading"><span>'+String(scene+1).padStart(2,'0')+' / 06</span><h3>'+plan[1]+'</h3></header><div class="detail-columns">'+sceneCard(active,scene)+'</div>';
  q('.viewer-steps').innerHTML=game.cards.map((c,i)=>'<button type="button" data-jump="'+i+'" aria-label="'+c.step+' '+screenPlans[active][i][1]+'" '+(i===scene?'aria-current="step"':'')+'>'+c.step+'</button>').join('');
  q('[data-viewer="prev"]').disabled=scene===0;q('[data-viewer="next"]').disabled=scene===5;
  status((scene+1)+' / 6 · '+plan[2]);fitScene();
 }
 function setMode(next){
  stop();mode=next;fit.hidden=mode==='play';frame.hidden=mode!=='play';q('.viewer-navigation').hidden=mode==='play';
  for(const name of ['view','play'])q('[data-viewer="'+name+'"]').setAttribute('aria-pressed',String(mode===name));
  if(mode==='view')draw();else{
   if(!frame.getAttribute('src')){ready=false;frame.src=new URL('index.html?game='+active+'&fit=1&rev='+version,base).href;status('목업을 불러오는 중…');}
   else{status('게임 화면의 버튼을 눌러 선택하세요.');send('status');}
  }
 }
 function schedule(){timer=setTimeout(()=>{
  if(mode==='view'){if(scene===5){stop();status('6 / 6 · 전체 흐름을 확인했습니다. 직접 플레이로 다른 선택을 해보세요.');return;}scene++;draw();}
  else if(ready)send('advance');
  if(q('[data-viewer="auto"]').getAttribute('aria-pressed')==='true')schedule();
 },Number(q('select').value));}
 function autoplay(){if(timer){stop();return;}if(mode==='view'&&scene===5){scene=0;draw();}if(mode==='play'&&playFinished)send('reset');q('[data-viewer="auto"]').textContent='Ⅱ 일시정지';q('[data-viewer="auto"]').setAttribute('aria-pressed','true');schedule();}
 function open(game,index,next,source){
  if(!games[game])return;active=game;scene=Math.max(0,Math.min(5,index));opener=source;ready=false;frame.removeAttribute('src');
  q('#viewer-title').textContent=games[game].title;previousOverflow=document.body.style.overflow;document.body.style.overflow='hidden';dialog.showModal();setMode(next);q('[data-viewer="close"]').focus();
 }
 document.addEventListener('click',e=>{const b=e.target.closest('[data-open-game]');if(b)open(b.dataset.openGame,Number(b.dataset.scene)||0,b.dataset.mode||'view',b);});
 dialog.addEventListener('click',e=>{
  const b=e.target.closest('button');if(!b)return;
  if(b.dataset.jump!==undefined){stop();scene=Number(b.dataset.jump);draw();return;}
  switch(b.dataset.viewer){
   case 'close':dialog.close();break;
   case 'view':case 'play':setMode(b.dataset.viewer);break;
   case 'auto':autoplay();break;
   case 'reset':stop();if(mode==='view'){scene=0;draw();}else send('reset');break;
   case 'prev':case 'next':stop();scene=Math.max(0,Math.min(5,scene+(b.dataset.viewer==='next'?1:-1)));draw();break;
  }
 });
 q('select').addEventListener('change',()=>{if(timer){stop();autoplay();}});
 dialog.addEventListener('keydown',e=>{if(mode==='view'&&!['SELECT','INPUT'].includes(e.target.tagName)&&['ArrowLeft','ArrowRight'].includes(e.key)){e.preventDefault();stop();scene=Math.max(0,Math.min(5,scene+(e.key==='ArrowRight'?1:-1)));draw();}});
 dialog.addEventListener('close',()=>{stop();ready=false;frame.removeAttribute('src');document.body.style.overflow=previousOverflow;opener?.focus();});
 window.addEventListener('message',e=>{
  if(!dialog.open||e.source!==frame.contentWindow||e.origin!==location.origin||e.data?.type!=='flow-state')return;
  ready=true;playFinished=!!e.data.finished;if(mode!=='play')return;
  if(e.data.manual)stop();
  status(e.data.finished?'플레이 완료 · 앨범을 확인하거나 다른 선택으로 다시 시작하세요.':e.data.label);
  if(e.data.finished)stop();
 });
 document.addEventListener('visibilitychange',()=>{if(document.hidden)stop();});
 new ResizeObserver(fitScene).observe(fit);
})();
