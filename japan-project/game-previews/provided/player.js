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

// Supplied artwork stays unchanged; controls below drive this local story mockup.
const gameId=location.pathname.match(/g2[1-5]/)?.[0];
const q=selector=>document.querySelector(selector);
function choiceButton(element,action){
 const button=document.createElement('button');button.type='button';
 button.className=element.className;button.style.cssText=element.style.cssText;
 button.innerHTML=element.innerHTML;element.replaceWith(button);
 button.onclick=()=>{if(auto)stopAutoplay();action(button);};return button;
}
function markChoice(button,selected){button.classList.toggle('on',selected);button.classList.toggle('pick',selected);button.setAttribute('aria-pressed',String(selected));}
function textAt(selector,text){q(selector).textContent=text;}
function imageAt(selector,file){q(selector).src='img/'+file;}
let conversationContext='함께한 약속';

if(gameId==='g25'){
 const routes=[
  {name:'조용한 곳에서 만나기',reply:'조용한 곳을 골라줘서 고마워. 오늘은 너에게만 본모습을 보여줄게.',image:'scene.jpg',ending:'둘만의 비밀을 나누는 연인',cap:'둘만의 조용한 만남. 본모습을 보여준 순간을 회상 앨범에 남긴다.'},
  {name:'사람 많은 곳에서 만나기',reply:'사람들 앞에서는 인간 모습으로 있을게. 오늘은 평범한 데이트를 즐기자.',image:'human.jpg',ending:'낮의 일상을 함께하는 연인',cap:'사람들 사이에서 인간 모습으로 만난 데이트. 정체는 둘만의 비밀로 남긴다.'},
  {name:'오늘은 만나지 않기',reply:'오늘은 쉬어도 괜찮아. 만나지 못해도 메시지로 우리 이야기를 이어가자.',image:'avatar_day.jpg',ending:'서로의 시간을 존중하는 관계',cap:'오늘은 직접 만나지 않았다. 밤에 나눈 메시지와 다음 만남의 약속을 회상에 남긴다.'}
 ];
 const options=[...document.querySelectorAll('#s2 .opt')].map((el,i)=>choiceButton(el,()=>selectMeeting(i)));
 function selectMeeting(i){const route=routes[i];options.forEach((b,j)=>markChoice(b,i===j));conversationContext=route.name;
  CHATS.s3=[['',route.reply],['me',i===2?'편히 쉬어. 다음에 만나자.':'좋아. 어제 정한 약속대로 하자.'],['','네가 고른 약속, 기억하고 있어.']];
  textAt('#s3btn',i===2?'밤의 메시지 보기':'약속한 만남으로');
  textAt('#s4 .topbar b',i===2?'밤 · 메시지의 추억':'밤 · 약속한 만남');imageAt('#s4img img',route.image);
  textAt('#s4cap',route.cap);textAt('#s4more .label','기억한 선택 · '+route.name);
  imageAt('#s5 .charbox img',i===0?'fox.jpg':route.image);textAt('#s5 .h',route.ending);
  textAt('#s5 .sub','7일 동안 대화와 약속을 이어간 경로 예시. 기억한 약속 · '+route.name);
  STEPS[3].d=route.reply;STEPS[4].t=i===2?'4. 밤의 메시지 · 회상 기록':'4. 약속한 만남 · 상황 이미지';STEPS[4].d=route.cap;
 }
 selectMeeting(0);
}
if(gameId==='g23'){
 let witch=2;const working=[false,true,true];
 const names=['마녀 1','마녀 2','마녀 3'],dreams=['나만의 마법 정원을 만들고 싶어.','새 연금술을 완성하고 싶어.','내 이름을 건 향수를 만들고 싶어.'];
 const portraits=[...document.querySelectorAll('#s1 .charbox')].map((el,i)=>choiceButton(el,()=>{witch=i;updateSalon();}));
 const duties=[...document.querySelectorAll('#s2 .opt')].map((el,i)=>choiceButton(el,()=>{working[2-i]=!working[2-i];updateSalon();}));
 function updateSalon(){const name=names[witch],income=working.filter(Boolean).length*100;
  portraits.forEach((b,i)=>{markChoice(b,i===witch);b.setAttribute('aria-label',names[i]+' 선택');});
  duties.forEach((b,i)=>{markChoice(b,working[2-i]);b.querySelector('span').textContent=working[2-i]?'영업 · +100 G':'휴식';});
  textAt('#s2 .label','오늘 수익 '+income+' G · 폐점 후 '+name+' 대화');
  textAt('#s3 .topbar b','폐점 후 · '+name+' 대화');textAt('#s3 .coin','수익 +'+income+' G');
  CHATS.s3=[['',working[witch]?'오늘 함께 영업하느라 수고했어.':'오늘 쉬게 해줘서 고마워.'],['',dreams[witch]],['me','그 꿈, 함께 이루자.']];
  for(const selector of ['#s3 .charbox img','#s4img img','#s5 .charbox img'])imageAt(selector,'witch'+(witch+1)+'.jpg');
  textAt('#s4cap',name+'의 꿈 · '+dreams[witch]);textAt('#s4more .chip.on',name+' 앨범 1');
  textAt('#s5 .sub','오늘 수익 '+income+' G. '+name+'의 약속을 앨범에 저장했다. 다음 영업으로 이야기를 이어간다.');
  conversationContext=name+'의 꿈';
 }
 updateSalon();
}
if(gameId==='g24'){
 let party=[0,1];const names=['기사','엘프','마족'],files=['knight.jpg','elf.jpg','demon.jpg'];
 const portraits=[...document.querySelectorAll('#s1 .charbox')].map((el,i)=>choiceButton(el,()=>{if(party.includes(i)){party=party.filter(n=>n!==i);}else{if(party.length===2)party.shift();party.push(i);}updateParty();}));
 function updateParty(){portraits.forEach((b,i)=>{markChoice(b,party.includes(i));b.setAttribute('aria-label',names[i]+' 편성');});
  const start=q('#s1 [data-go]');start.disabled=party.length!==2;start.textContent=party.length===2?'원정 출발 · '+party.map(i=>names[i]).join(' + '):'동료 두 명을 선택하세요';
  if(party.length!==2)return;const friend=party[1],name=names[friend];
  document.querySelectorAll('#s2 .charbox img').forEach((img,i)=>img.src='img/'+files[party[i]]);
  document.querySelectorAll('#s2 .hp>span:first-child').forEach((el,i)=>el.textContent=names[party[i]]);
  const lines=q('#s2log').children;lines[0].textContent='턴 1 · '+names[party[0]]+'가 길을 열었다';lines[1].textContent='턴 2 · '+name+' 엄호에 성공했다';
  textAt('#s2pill',name+' 엄호 · 기억됨');textAt('#s3 .topbar b','귀환 후 · '+name+' 대화');
  CHATS.s3=[['','아까 나를 엄호해준 거, 기억하고 있어.'],['me','네가 무사해서 다행이야.'],['','다음 의뢰도 함께 가자.']];
  for(const selector of ['#s3 .charbox img','#s4img img','#s5 .charbox img'])imageAt(selector,files[friend]);
  textAt('#s4more .chip.on',name+' 서사 기록 1');textAt('#s4cap',name+' 야영 기록 · 함께 싸운 기억과 다음 원정의 약속.');
  textAt('#s5 .sub',party.map(i=>names[i]).join(' + ')+' 파티로 원정 완료. '+name+' 개인 의뢰가 열렸다.');conversationContext=name+'의 다음 원정';
 }
 updateParty();
}
if(gameId==='g21'){
 let tile=null,matches=0;
 const origins=[...document.querySelectorAll('#s1 .charbox')].map((el,i)=>choiceButton(el,()=>{origins.forEach((b,j)=>markChoice(b,i===j));window.selectCollectedOrigin(i);textAt('#s1 .toast','원형 '+String.fromCharCode(65+i)+' 선택 · 다음 합성에 반영');}));origins.forEach((b,i)=>{markChoice(b,i===0);b.setAttribute('aria-label','원형 '+String.fromCharCode(65+i)+' 선택');});
 const tiles=[...document.querySelectorAll('#s1 .tile')].map(el=>choiceButton(el,b=>{
  if(b.disabled)return;if(tile===b){markChoice(b,false);tile=null;return;}
  if(tile&&tile.textContent===b.textContent){tile.disabled=b.disabled=true;tile.classList.add('matched');b.classList.add('matched');tile=null;matches++;textAt('#s1 .toast',matches===6?'클리어! 원형 획득':'같은 타일 '+matches+'쌍 제거');}
  else{if(tile)markChoice(tile,false);tile=b;markChoice(b,true);}
 }));
 textAt('#s1 .toast','같은 모양 두 개를 눌러 지우세요');
 const save=q('#s3 .chip.lock.on');choiceButton(save,b=>{const saved=b.getAttribute('aria-pressed')!=='true';markChoice(b,saved);b.textContent=saved?'보관 완료':'승계';window.keepFusionTrait(saved);textAt('#s3 .card .sub',saved?'희귀 특징을 다음 합성 후보에 보관했다':'다음 합성의 원형으로 보관');});
}
// ponytail: replies are local examples; real AI conversation belongs to the game implementation.
for(const label of document.querySelectorAll('.screen .card>.sub')){
 if(!/입력|답장/.test(label.textContent))continue;
 const card=label.parentElement,screen=card.closest('.screen');
 const form=document.createElement('form');form.className='card chat-form';
 form.innerHTML='<input aria-label="대화 입력" maxlength="80" placeholder="대화 입력 · 예시 응답"><button type="submit" class="chip on">보내기</button>';card.replaceWith(form);
 form.querySelector('input').onfocus=()=>{if(auto)stopAutoplay();};
 form.onsubmit=event=>{event.preventDefault();const input=form.querySelector('input'),message=input.value.trim();if(!message)return;
  stopAutoplay();const chat=document.getElementById(screen.id+'chat');chat.replaceChildren();
  for(const [who,text] of [['me',message],['','“'+message+'” 기억할게. 다음에도 우리 이야기를 이어가자.']]){const bubble=document.createElement('div');bubble.className='bubble '+who+' show';bubble.textContent=text;chat.append(bubble);}
  const nextChat=ORDER.slice(ORDER.indexOf(screen.id)+1).find(id=>TYPES[id]==='chat');
  if(nextChat)CHATS[nextChat]=[['','어제 네가 “'+message+'”라고 했지. 기억하고 있어.'],['me','응, 우리 약속이야.'],['','오늘도 함께 이야기를 이어가자.']];
  const scene=ORDER.slice(ORDER.indexOf(screen.id)+1).find(id=>TYPES[id]==='scene');
  if(scene)textAt('#'+scene+'more .label','기억한 대화 · '+message);
  input.value='';
 };
}
// Interacting with any existing native choice also hands autoplay back to the reader.
document.addEventListener('click',event=>{if(auto&&event.target.closest('[data-period],[data-slot],[data-origin],[data-gacha]'))stopAutoplay();},true);
