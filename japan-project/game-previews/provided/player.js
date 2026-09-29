// Fit the supplied phone + explanation layout without a second viewer toolbar.
function fitSuppliedPlayer(){const desktop=innerWidth>900,stage=document.querySelector('.stage'),phone=document.querySelector('.phone');document.body.classList.toggle('standalone-desktop',desktop);document.body.classList.toggle('standalone-mobile',!desktop);if(desktop){stage.style.transform='translate(-50%,-50%) scale('+Math.min(1,innerWidth/1600,innerHeight/900)+')';phone.style.zoom='';}else{stage.style.transform='';phone.style.zoom=String(Math.min(1,(innerWidth-28)/390));}}
window.addEventListener('resize',fitSuppliedPlayer);fitSuppliedPlayer();
// The supplied player hides its controls while autoplay runs and restores them on completion.
const autoplayStatus=document.createElement('div');autoplayStatus.className='autoplay-status';autoplayStatus.setAttribute('role','status');autoplayStatus.setAttribute('aria-live','polite');autoplayStatus.innerHTML='<span class="autoplay-spinner" aria-hidden="true"></span>자동 재생 중';document.body.append(autoplayStatus);
const suppliedControls=document.getElementById('ctl');
function updateAutoplayStatus(){autoplayStatus.hidden=!suppliedControls.classList.contains('hidden');}
new MutationObserver(updateAutoplayStatus).observe(suppliedControls,{attributes:true,attributeFilter:['class']});updateAutoplayStatus();
