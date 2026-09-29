// Fit the supplied phone + explanation layout without a second viewer toolbar.
function fitSuppliedPlayer(){const desktop=innerWidth>900,stage=document.querySelector('.stage'),phone=document.querySelector('.phone');document.body.classList.toggle('standalone-desktop',desktop);document.body.classList.toggle('standalone-mobile',!desktop);if(desktop){stage.style.transform='translate(-50%,-50%) scale('+Math.min(1,innerWidth/1600,innerHeight/900)+')';phone.style.zoom='';}else{stage.style.transform='';phone.style.zoom=String(Math.min(1,(innerWidth-28)/390));}}
window.addEventListener('resize',fitSuppliedPlayer);fitSuppliedPlayer();
// The supplied player hides its controls while autoplay runs and restores them on completion.
const autoplayStatus=document.createElement('div');autoplayStatus.className='autoplay-status';autoplayStatus.setAttribute('role','status');autoplayStatus.setAttribute('aria-live','polite');autoplayStatus.innerHTML='<span class="autoplay-spinner" aria-hidden="true"></span>자동 재생 중<button type="button" class="autoplay-stop">자동 재생 멈춤</button>';document.body.append(autoplayStatus);
const suppliedControls=document.getElementById('ctl');
function updateAutoplayStatus(){autoplayStatus.hidden=!suppliedControls.classList.contains('hidden');}
new MutationObserver(updateAutoplayStatus).observe(suppliedControls,{attributes:true,attributeFilter:['class']});updateAutoplayStatus();

function stopAutoplay(){
 auto=false;flowRun++;
 const screen=document.querySelector('.screen.on'),id=screen.id;
 if(TYPES[id]==='chat'){
  const chat=document.getElementById(id+'chat');chat.replaceChildren();
  for(const [who,txt] of CHATS[id]){const bubble=document.createElement('div');bubble.className=who==='day'?'label':'bubble '+who+' show';bubble.textContent=txt;chat.append(bubble);}
  document.getElementById(id+'btn').classList.remove('hidden');
 }else if(TYPES[id]==='battle'){
  for(const line of document.getElementById(id+'log').children)line.classList.add('show');
  document.getElementById(id+'pill').style.opacity=1;
 }else if(TYPES[id]==='scene'){
  document.getElementById(id+'img').style.opacity=1;
  document.getElementById(id+'cap').style.opacity=1;
 }
 suppliedControls.classList.remove('hidden');
 document.getElementById('sn').textContent='수동 진행 · 화면의 버튼으로 이어서 진행하세요.';
 updateAutoplayStatus();
}
autoplayStatus.querySelector('.autoplay-stop').onclick=stopAutoplay;
