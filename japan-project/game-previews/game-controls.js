(() => {
 const embedded=new URLSearchParams(location.search).get('fit')==='1';
 if(embedded)document.documentElement.classList.add('fit-game');
 let manual=false;
 const finish=()=>({g21:6,g22:4,g23:4,g24:4,g25:4}[gameId]===state.phase);
 function report(){
  if(window.parent!==window)window.parent.postMessage({type:'flow-state',finished:finish(),manual,label:(Math.min(state.phase+1,steps[gameId].length))+' / '+steps[gameId].length+' · '+(steps[gameId][state.phase]||'다시 도전')},location.origin==='null'?'*':location.origin);
  manual=false;fit();
 }
 function fit(){if(embedded){const width=innerWidth<620?360:Math.min(960,innerWidth);root.style.width=width+'px';root.classList.toggle('mobile-game',width===360);const scale=Math.min(1,innerWidth/width,innerHeight/root.offsetHeight);root.style.transform='translate(-50%,-50%) scale('+scale+')';}for(const art of root.querySelectorAll('.world>.game-art,.battlefield>.game-art')){const host=art.parentElement,width=Math.max(host.clientWidth,host.clientHeight*4/3);art.style.width=width+'px';art.style.height=(width*3/4)+'px';}}
 function advance(){
  if(finish()){report();return;}
  let action={g21:['collect','combine','inherit-open','inherit-save','workshop-meet','workshop-album'],g22:['home-day','home-reply:sweet','home-scene','home-ending'],g23:['salon-close','salon-reply','salon-album','salon-upgrade'],g24:['rpg-start',state.guarded?(state.combo?'combo':'attack'):'guard','rpg-talk','rpg-album'],g25:['fox-reply:accept','fox-place:옥상','fox-meet','fox-ending']}[gameId][state.phase];
  if(state.phase===5&&gameId==='g24')action='rpg-retry';
  if(action&&allowed.has(action))act(action);
 }
 root.addEventListener('click',e=>{if(e.target.closest('button[data-action]'))manual=true;},true);
 window.addEventListener('game-render',report);
 window.addEventListener('message',e=>{
  if(e.source!==window.parent||e.origin!==location.origin||e.data?.type!=='flow-control')return;
  if(e.data.command==='reset')act('reset');
  else if(e.data.command==='advance')advance();
  else if(e.data.command==='status')report();
 });
 new ResizeObserver(fit).observe(root);window.addEventListener('resize',fit);window.addEventListener('load',report);report();
})();
