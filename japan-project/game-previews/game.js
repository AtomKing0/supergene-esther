const requested=new URLSearchParams(location.search).get('game');
const gameId=['g21','g22','g23','g24','g25'].includes(requested)?requested:'g21';
const titles={g21:'계승 공방',g22:'14일의 비밀 동거',g23:'마녀의 비밀 살롱',g24:'왕도 계약 조사대',g25:'7일간 비밀연애'};
const themes={g21:'workshop',g22:'home',g23:'salon',g24:'rpg',g25:'fox'};
const steps={g21:['원형 수집','확률 합성','결과 확인','특징 승계','대화·약속','만남','앨범'],g22:['하루 계획','저녁 대화','다음 날','관계 장면','14일 엔딩'],g23:['마녀·영업','비밀 대화','특별 예약','앨범','살롱 확장'],g24:['동료 선택','턴제 원정','귀환 대화','야영','앨범·다음 의뢰'],g25:['비밀 메시지','만남 선택','기억·약속','밤의 만남','7일 엔딩']};
const art=g=>'../assets/game-art/'+g+'.png';
const initial=()=>({phase:0,affinity:24,materials:18,gold:360,day:gameId==='g25'?2:3,activities:['요리','휴식'],preference:'',witch:'리엘',companion:'에린',enemy:100,hp:100,turn:1,guarded:false,combo:1,log:'공격·엄호·회복 중 행동을 선택하세요.',message:'',result:null,inherit:false,album:[],notice:'',place:'옥상',ending:'',gacha:'',parents:['0','1'],editSlot:0,savedOrigin:null,generation:1});
let state=initial(),allowed=new Set();
const root=document.getElementById('game');
function button(label,action,cls='',disabled=false){if(!disabled)allowed.add(action);return '<button type="button" data-action="'+action+'" class="'+cls+'" '+(disabled?'disabled':'')+'>'+label+'</button>';}
const primary=(label,action,disabled=false)=>button(label,action,'primary wide-button',disabled);
const meter=(value,label)=>'<div class="note-line"><span>'+label+'</span><span>'+value+'%</span></div><div class="track"><div class="fill" style="--value:'+value+'%"></div></div>';
const progress=()=>'<div class="step-label">'+Math.min(state.phase+1,steps[gameId].length)+' / '+steps[gameId].length+' · '+steps[gameId][state.phase]+'</div><div class="progress">'+steps[gameId].map((_,i)=>'<span class="'+(i<=state.phase?'done':'')+'"></span>').join('')+'</div>';
const heading=(label,title,desc='')=>'<div><div class="eyebrow">'+label+'</div><h1>'+title+'</h1>'+(desc?'<p class="muted">'+desc+'</p>':'')+'</div>';
const box=content=>'<div class="panel-box">'+content+'</div>';
const memory=text=>'<div class="memory"><strong>둘만의 기억</strong>'+text+'</div>';
const artPanels={g21:[0,1,1,2,2,3,3],g22:[1,1,2,2,3],g23:[0,2,3,3,3],g24:[0,1,2,3,3,1],g25:[0,1,0,2,3]};
const sceneArtwork=(panel,cls='')=>'<div class="game-art quadrant-'+panel+' '+cls+'"><img src="../assets/game-art/'+gameId+'-scenes.png" alt="'+titles[gameId]+' 제안용 장면 일러스트"></div>';
const portrait=(g,name,role,speech,label)=>'<div class="world">'+sceneArtwork(artPanels[gameId][state.phase]??0)+'<span class="world-label">'+label+'</span><div class="character"><div class="name">'+name+'</div><div class="role">'+role+'</div><p class="speech">“'+speech+'”</p></div></div>';
const illustration=(title,caption,g=gameId)=>'<figure class="album-photo reveal">'+sceneArtwork(artPanels[gameId][state.phase]??3)+'<figcaption><strong>'+title+'</strong><span>'+caption+'</span><small>제안용 대표 장면 · 선택 결과는 대화와 기록에 반영</small></figcaption></figure>';
function saveScene(title,caption,g=gameId){if(!state.album.some(s=>s.title===title))state.album.push({title,caption,g});}
const albumView=()=>'<div class="album-grid">'+state.album.map(s=>illustration(s.title,s.caption,s.g)).join('')+'</div>';
const completed=(title,desc,continuation)=>heading('FLOW COMPLETE',title,desc)+albumView()+box('<strong>다음에 이어질 이야기</strong><p class="muted">'+continuation+'</p>')+primary('다른 선택으로 다시 플레이','reset');
function pick(pool,roll=Math.random()){let sum=0;for(const item of pool){sum+=item.chance;if(roll<sum/100)return {...item};}return {...pool[pool.length-1]};}
const appearancePool=[{name:'마족형 · 은빛 헤어',chance:50,g:'g21'},{name:'안드로이드형 · 금빛 헤어',chance:35,g:'g22'},{name:'여우형 · 밤빛 헤어',chance:15,g:'g25'}];
const personalityPool=[{name:'호기심',chance:50},{name:'다정함',chance:30},{name:'도도함',chance:20}];
const traitPool=[{name:'특별 특징 없음',chance:70},{name:'은빛 날개',chance:20},{name:'별빛 눈동자',chance:10}];
const odds=pool=>pool.map(x=>x.name+' '+x.chance+'%').join('<br>');
const origins={
 '0':{name:'세라 · 마족형',base:0,factors:['은빛 헤어 ★★★','다정함 ★★','은빛 날개 ★★★'],lineage:['마족형 원형','날개 인자']},
 '1':{name:'노아 · 안드로이드형',base:1,factors:['금빛 헤어 ★★','호기심 ★★★','별빛 눈동자 ★★'],lineage:['기계형 원형','별빛 인자']},
 '2':{name:'시즈쿠 · 여우형',base:2,factors:['밤빛 헤어 ★★★','도도함 ★★★','별빛 눈동자 ★★'],lineage:['여우형 원형','밤빛 인자']}
};
function originFor(key){return key==='saved'?state.savedOrigin:origins[key];}
function combination(){
 const key=state.parents.map(k=>originFor(k).base).sort().join('');
 const profiles={
  '01':{appearance:[50,35,15],personality:[50,30,20],trait:[70,20,10],affinity:'◎',rate:.6},
  '02':{appearance:[45,10,45],personality:[20,40,40],trait:[50,30,20],affinity:'○',rate:.5},
  '12':{appearance:[10,45,45],personality:[60,10,30],trait:[65,5,30],affinity:'○',rate:.5},
  '00':{appearance:[75,15,10],personality:[20,60,20],trait:[50,40,10],affinity:'◎',rate:.6},
  '11':{appearance:[10,75,15],personality:[75,10,15],trait:[60,5,35],affinity:'◎',rate:.6},
  '22':{appearance:[10,15,75],personality:[20,15,65],trait:[55,5,40],affinity:'◎',rate:.6}
 };
 return profiles[key];
}
function pools(){const c=combination();return {appearance:appearancePool.map((x,i)=>({...x,chance:c.appearance[i]})),personality:personalityPool.map((x,i)=>({...x,chance:c.personality[i]})),trait:traitPool.map((x,i)=>({...x,chance:c.trait[i]}))};}
function carryInfo(){
 if(!state.savedTrait||!state.parents.includes('saved'))return '';
 const pool=pools()[state.savedTrait.kind==='personality'?'personality':'trait'];
 const basic=pool.find(x=>x.name===state.savedTrait.name).chance,rate=combination().rate;
 return state.savedTrait.name+' 최종 발현 '+Math.round(rate*100+(1-rate)*basic)+'%<br><small>우선 계승 '+Math.round(rate*100)+'% + 미발현 시 기본 추첨 반영</small>';
}
function originPicker(){
 const c=combination();
 return '<div class="lineage-compatibility">조합 상성 <b>'+c.affinity+'</b><span>발현 확률은 아래에서 확인</span></div><div class="origin-slots">'+state.parents.map((key,i)=>{const o=originFor(key);return button('<small>원형 '+(i?'B':'A')+' · 변경</small><b>'+o.name+'</b><span>'+o.factors.join('<br>')+'</span><em>이전 계보 · '+o.lineage.join(' + ')+'</em>','source:'+i,state.editSlot===i?'selected':'');}).join('')+'</div><div class="origin-candidates"><small>원형 '+(state.editSlot?'B':'A')+' 선택 · ★는 인자 등급</small>'+Object.entries({...origins,...(state.savedOrigin?{saved:state.savedOrigin}:{})}).map(([key,o])=>button('<b>'+o.name+'</b><span>'+o.factors[2]+'</span>','origin:'+key,state.parents[state.editSlot]===key?'selected':'',state.parents[1-state.editSlot]===key)).join('')+'</div>';
}

function workshop(){
 let content,speech='새 원형을 모아, 어떤 모습의 파트너를 만나고 싶어?';
 if(state.phase===0){const filled=[0,1,6,7,12,13,14,19,20,25,26,27,28,29,32];content=heading('01 / 취향 원형 수집','블록을 놓고<br>합성 재료를 받으세요.','축약 의뢰 · 마지막 한 수를 체험합니다.')+box('<div class="box-title">목표 4줄 · 현재 3줄</div><div class="puzzle" aria-label="블록 퍼즐 보드">'+Array.from({length:36},(_,i)=>'<div class="cell '+(filled.includes(i)?'filled':'')+'"></div>').join('')+'</div>')+primary('블록 놓기 · 원형과 재료 받기','collect')+button('체험 가챠 1회 · 원형 뽑기','gacha')+'<p class="muted">체험 재화 사용 · 실제 결제 없음</p>';}
 if(state.phase===1){const ps=pools();content=heading('02 / 계승 원형 선택','두 원형을 고르고,<br>인자와 발현 확률을 비교하세요.','체험 보유 원형 3종 · 원형 본체는 소모하지 않음')+originPicker()+box('<div class="odds"><strong>기본 추첨 확률 · 목업 가정</strong><div><b>외형</b>'+odds(ps.appearance)+'</div><div><b>성격</b>'+odds(ps.personality)+'</div><div><b>희귀 특징</b>'+odds(ps.trait)+'</div></div>'+(carryInfo()?'<p class="carry-result">'+carryInfo()+'</p>':''))+(state.gacha?memory('가챠로 확보한 원형 · '+state.gacha):'')+primary('확률 합성하기 · 재료 12','combine',state.materials<12)+button('체험 가챠 · 다른 원형 뽑기','gacha');}
 if(state.phase===2){const r=state.result;speech=r.personality==='도도함'?'쉽게 마음을 주진 않아. 그래도 네 이야기는 들어볼게.':r.personality==='다정함'?'처음 만났지만, 네 하루를 함께 듣고 싶어.':'너에 대해 궁금한 게 많아. 먼저 이름을 알려줄래?';content=heading('03 / 합성 결과','새 파트너를<br>만났습니다.')+box('<div class="source-receipt">계승 출처 · '+state.parents.map(k=>originFor(k).name).join(' + ')+'</div><div class="result reveal">'+r.appearance+'</div><div class="chips"><span class="chip">성격 · '+r.personality+'</span><span class="chip rare">'+r.trait+'</span></div><p class="muted">외형·성격·희귀 특징을 각각 추첨했습니다.'+(state.savedTrait?'<br>승계 후보 · '+(state.inherit?'발현':'미발현 · 기본 추첨 결과 적용'):'')+'</p>')+primary('희귀 특징 승계 설정','inherit-open');}
 if(state.phase===3){content=heading('04 / 다음 합성에 승계','이번 결과를<br>다음 조합에 이어갑니다.',state.result.trait==='특별 특징 없음'?'희귀 특징 미획득 · 이번 성격을 승계 후보로 보관':'희귀 특징 획득 · 다음 합성의 승계 후보로 보관')+box('<strong>승계 후보 · '+(state.result.trait==='특별 특징 없음'?state.result.personality:state.result.trait)+'</strong><p class="muted">파트너를 다음 합성의 원형으로 다시 선택할 수 있습니다.<br>계보와 인자를 보관하며, 발현 확률은 다음 조합에서 확인합니다.</p>')+primary('승계 후보 보관 · 첫 대화로','inherit-save');}
 if(state.phase===4){speech=state.result.personality==='도도함'?'별을 보는 약속이라… 늦으면 먼저 가버릴 거야.':state.result.personality==='다정함'?'별을 좋아하는구나. 네가 좋아하는 시간을 함께하고 싶어.':'별자리도 알려줄래? 오늘 밤에 같이 찾아보고 싶어.';content=heading('05 / 대화·약속','성격이 다른 그녀와<br>첫 약속을 만듭니다.')+box('나: 오늘 밤, 같이 별을 볼까?<br>그녀: '+speech)+primary('별을 보는 약속 저장 · 만남으로','workshop-meet');}
 if(state.phase===5){speech='네가 별을 좋아한다고 했지. 오늘은 내가 먼저 기다렸어.';content=heading('06 / 약속한 만남','그녀가 기억한 약속,<br>둘만의 장면이 됩니다.')+illustration('창가에서 별을','첫 대화에서 정한 약속을 함께 지켰다.',state.result.g)+memory(state.result.appearance+' · '+state.result.personality+'<br>약속 · 오늘 밤 함께 별 보기')+primary('사진 저장 · 특별 앨범 보기','workshop-album');}
 if(state.phase===6){speech='약속했던 밤을 기억할게. 다음에는 어디로 갈까?';content=completed('첫 파트너의<br>앨범이 완성됐습니다.','외형·성격·약속이 한 파트너의 기록으로 남았습니다.','다음 합성에 보관한 특징을 승계하거나, 이 파트너와 새 약속을 만듭니다.')+primary('기억 유지 · 다음 확률 합성','workshop-again');}
 const r=state.result;return portrait(r?r.g:'g21','세라',r?r.appearance+' · '+r.personality:'성인 인공생명체',speech,'WORKSHOP / 공방')+'<div class="panel">'+progress()+content+'</div>';
}
const activityResponse=()=>({요리:'같이 만든 저녁',외출:'함께 걸었던 길',독서:'함께 읽은 이야기',휴식:'나란히 쉬었던 오후'}[state.activities[0]]);
function home(){
 let content,speech='오늘은 어떤 하루를 함께할까?';
 if(state.phase===0){content=heading('DAY 03 / 하루 두 칸','오전과 저녁의<br>활동을 고르세요.')+['오전','저녁'].map((slot,i)=>box('<div class="box-title">'+slot+' · '+state.activities[i]+'</div><div class="activities">'+['요리','외출','독서','휴식'].map(a=>button(a,'activity:'+i+':'+a,state.activities[i]===a?'selected':'')).join('')+'</div>')).join('')+primary('두 활동으로 하루 보내기','home-day');}
 if(state.phase===1){speech=activityResponse()+'이 좋았어. 다음에는 네가 좋아하는 걸 해보고 싶어.';content=heading('DAY 03 / 저녁 대화','함께한 하루 뒤,<br>내 취향을 알려줍니다.')+memory('오늘의 활동 · '+state.activities.join(' → '))+box(speech)+'<div class="message-choices">'+button('나는 달콤한 맛을 좋아해.','home-reply:sweet')+button('다음에도 함께 산책하고 싶어.','home-reply:walk')+'</div>';}
 if(state.phase===2){speech=state.preference==='sweet'?'네가 좋아하는 달콤한 간식을 준비했어. 오늘도 함께 먹자.':'어제 산책하고 싶다고 했지. 오늘은 내가 좋아하는 길을 알려줄게.';content=heading('DAY 04 / 그녀의 첫 제안','어제 말한 취향을<br>그녀가 먼저 꺼냅니다.')+box('<p class="diary">“'+speech+'”</p>')+memory('어제의 대화 · '+state.message)+primary('그녀의 제안 받아들이기','home-scene');}
 if(state.phase===3){content=heading('DAY 04 / 관계 전환점','둘만의 약속이<br>한 장의 추억으로 남습니다.')+illustration(state.preference==='sweet'?'함께 만든 달콤한 저녁':'둘만의 산책',state.message)+primary('사진 저장 · 14일째 엔딩 보기','home-ending')+'<p class="muted">목업에서는 5~13일을 생략하고 결말로 이어집니다.</p>';}
 if(state.phase===4){content=completed('14일 엔딩 ·<br>'+state.ending,'함께한 활동과 내가 말한 취향을 기억하는 관계.','DLC 제안 · 본편의 기억을 이어가는 연인 후일담과 새 장소.');speech='내일도 너와 함께하고 싶어. 이번에는 내가 먼저 약속할게.';}
 return portrait('g22','유나','성인 안드로이드 · 동거 파트너',speech,'OUR ROOM / 함께 사는 방')+'<div class="panel">'+progress()+content+'</div>';
}
const witches={리엘:{g:'g23',job:'조향',secret:'언젠가 내 이름을 건 향수를 만들고 싶어.',reply:'네가 만든 향은 오래 기억하고 싶어.',scene:'리엘의 비밀 향수'},모르나:{g:'g21',job:'연금술',secret:'성공만큼 실패도 두려워. 너에게는 말해도 괜찮겠지?',reply:'실패해도 다음 실험은 함께하자.',scene:'모르나와 마지막 실험'},루나:{g:'g25',job:'응대',secret:'항상 웃고 있지만, 오늘은 네 곁에서 쉬고 싶어.',reply:'오늘은 내 앞에서 편하게 쉬어.',scene:'루나의 쉬는 밤'}};
function salon(){
 const w=witches[state.witch];let content,speech='내 특기에 맞는 주문을 맡겨줘.';
 if(state.phase===0){content=heading('NIGHT 05 / 마녀·영업','오늘은 누구와<br>함께 일할까요?')+'<div class="witches">'+Object.entries(witches).map(([n,w])=>button('<span class="origin-symbol">'+({리엘:'⚗',모르나:'◈',루나:'☾'}[n])+'</span>'+n+'<small>'+w.job+'</small>','witch:'+n,state.witch===n?'selected':'')).join('')+'</div>'+box('<div class="box-title">마녀별 특기 주문 2건</div><div class="order"><div>'+w.job+' 주문<small>특기 일치 · 수익 120 G</small></div><span class="price">120 G</span></div><div class="order"><div>단골 주문<small>기본 수익 80 G</small></div><span class="price">80 G</span></div>')+primary(state.witch+'에게 배정 · 영업 마치기','salon-close');}
 if(state.phase===1){speech=w.secret;content=heading('CLOSED / 비밀 대화','문을 닫은 뒤,<br>그녀가 속내를 꺼냅니다.')+memory(state.witch+'와 특기 주문을 마쳤다. 영업 수익 +200 G')+box('<p class="diary">“'+w.secret+'”</p>')+primary(w.reply,'salon-reply');}
 if(state.phase===2){speech='다음 예약은 다른 손님 말고, 너를 위해 비워둘게.';content=heading('PRIVATE / 특별 예약','영업 중과 다른,<br>그녀만의 모습.')+illustration(w.scene,w.reply,w.g)+memory('비밀 · '+w.secret)+primary('사진 저장 · 마녀의 특별 앨범 보기','salon-album');}
 if(state.phase===3){content=heading('ALBUM / 특별 앨범','그녀의 비밀과<br>약속을 모았습니다.')+albumView()+box('<strong>살롱 확장 · 개인 응접실</strong><p class="muted">비용 200 G · 다음 만남의 공간 해금</p>')+primary('200 G로 개인 응접실 열기','salon-upgrade');}
 if(state.phase===4){content=completed('살롱 확장 완료 ·<br>새 만남의 공간','영업 수익이 그녀와의 다음 만남으로 이어집니다.','DLC 제안 · 새 마녀의 개인 이야기와 특별 예약 테마.')+primary('다음 영업 시작','salon-again');speech='이 공간에서는 우리 이야기만 하자.';}
 return portrait(w.g,state.witch,'밤의 마녀 · '+w.job,speech,'MIDNIGHT SALON / 비밀 살롱')+'<div class="panel">'+progress()+content+'</div>';
}
const companions={에린:{g:'g24',role:'엘프 사수',quest:'에린의 숲 조사'},벨라:{g:'g21',role:'마족 마법사',quest:'벨라의 마력 조사'}};
function rpg(){
 const c=companions[state.companion];let content,world=portrait(c.g,state.companion,c.role,'다음 원정도 너와 함께하고 싶어.','CAMP / 야영지');
 if(state.phase===0){content=heading('PARTY / 두 명의 동료','기사와 함께할<br>두 번째 동료를 고르세요.')+box('리아 · 인간 기사 / 엄호 담당')+'<div class="witches companions">'+Object.entries(companions).map(([n,c])=>button('<span class="origin-symbol">'+(n==='에린'?'➶':'✧')+'</span>'+n+'<small>'+c.role+'</small>','companion:'+n,state.companion===n?'selected':'')).join('')+'</div>'+primary('2인 파티로 원정 출발','rpg-start');}
 if(state.phase===1){world='<div class="battlefield">'+sceneArtwork(1)+'<div class="enemy-hp">유적의 파수꾼'+meter(state.enemy,'HP')+'</div><span class="world-label">원정 · TURN '+state.turn+'</span><div class="battle-info"><div class="unit">리아 · '+state.companion+meter(state.hp,'파티 HP')+'</div></div></div>';content=heading('TURN '+state.turn,'동료와 함께<br>파수꾼을 쓰러뜨리세요.')+'<div class="commands">'+button('검격<small>피해 25 · 적 반격 12</small>','attack')+button('엄호<small>피해 15 · 반격 감소 · 신뢰 +3</small>','guard')+button('합동 기술<small>피해 45 · 남은 횟수 '+state.combo+'</small>','combo','',state.combo===0)+button('회복<small>HP +30 · 적 반격 12</small>','heal','',state.hp===100)+'</div>'+box('<div class="combat-log">'+state.log+'</div>');}
 if(state.phase===2){const recalled=state.guarded?'아까 나를 보호해준 거, 기억하고 있어.':'함께 끝까지 싸워준 거, 기억하고 있어.';content=heading('VICTORY / 귀환 후 대화','전투의 선택이<br>둘의 대화로 이어집니다.')+box('원정 보상 · 골드 +120 · 신뢰 +8')+memory(recalled)+primary(state.guarded?'네가 무사해서 다행이야.':'다음 원정도 함께 가자.','rpg-talk');world=portrait(c.g,state.companion,c.role,recalled,'RETURN / 원정 귀환');}
 if(state.phase===3){content=heading('CAMP / 개인 의뢰','그녀가 둘만의<br>다음 의뢰를 제안합니다.')+illustration(state.companion+(state.companion==='에린'?'과':'와')+' 야영지의 약속',state.guarded?'엄호한 선택을 기억하며 마음을 열었다.':'함께 싸운 기억으로 다음 원정을 약속했다.',c.g)+box('<strong>개인 의뢰 해금 · '+c.quest+'</strong>')+primary('야영 사진 저장 · 원정 앨범 보기','rpg-album');}
 if(state.phase===4){content=completed('원정 앨범 ·<br>다음 개인 의뢰 해금','전투 → 기억을 나누는 대화 → 야영 사진 → 개인 의뢰까지 완료.','DLC 제안 · 새 동료의 개인 의뢰·의상·상황 이미지.')+primary('현재 파티로 다음 의뢰 출발','rpg-again');}
 if(state.phase===5){content=heading('EXPEDITION FAILED','원정 실패 ·<br>다시 도전할 수 있습니다.')+box('엄호로 반격 피해를 줄이거나, 회복으로 다음 턴을 준비하세요.')+primary('같은 파티로 전투 재도전','rpg-retry');}
 return world+'<div class="panel">'+(state.phase===5?'':progress())+content+'</div>';
}
function fox(){
 let content,speech='내 비밀은 너만 알고 있어.';
 if(state.phase===0){content=heading('DAY 02 / 낮의 메시지','너에게만<br>비밀을 털어놓습니다.')+box('<div class="chat-header"><span class="chat-avatar">S</span><div>시즈쿠<div class="online">● 접속 중</div></div></div><div class="chat"><div class="bubble">오늘 정체를 들킬 뻔했어.<br>너에게만 이야기하고 싶었어.</div></div>')+'<div class="message-choices">'+button('어떤 모습이어도 너는 너야.','fox-reply:accept')+button('괜찮아. 천천히 말해줘.','fox-reply:wait')+'</div>';}
 if(state.phase===1){content=heading('DAY 02 / 오늘의 약속','어디에서<br>만날까요?')+box('<div class="bubble mine">'+state.message+'</div><p>시즈쿠: 안심했어. 오늘 밤 만나줄래?</p>')+'<div class="message-choices">'+button('조용한 옥상에서 만나자.','fox-place:옥상')+button('밤의 정원에서 만나자.','fox-place:정원')+'</div>';}
 if(state.phase===2){speech=state.preference==='accept'?'어떤 모습이어도 나라고 했지. 그 말을 믿어볼게.':'천천히 말해도 된다고 했지. 이제는 네게 보여주고 싶어.';content=heading('DAY 03 / 약속을 기억','다음 대화에서<br>어제의 말을 꺼냅니다.')+memory('어제 답장 · '+state.message+'<br>만남 장소 · '+state.place)+box('<p class="diary">“'+speech+'”</p>')+primary(state.place+'에서 밤의 만남으로','fox-meet');}
 if(state.phase===3){speech=state.preference==='accept'?'그 말을 믿고, 오늘은 숨기지 않을게.':'기다려줘서 고마워. 오늘은 내 진짜 모습을 보여주고 싶어.';content=heading('DAY 03 / 정체 공개','나에게만 보여주는<br>그녀의 본모습.')+illustration(state.place+'에서 드러낸 비밀',state.message+' 그 답장을 기억한 밤.')+primary('만남 사진 저장 · 7일째 엔딩 보기','fox-ending')+'<p class="muted">목업에서는 4~6일을 생략하고 결말로 이어집니다.</p>';}
 if(state.phase===4){speech='이제 네 앞에서는 숨기지 않아도 되겠지.';content=completed('7일 엔딩 ·<br>'+state.ending,'답장·만남의 장소·정체 공개가 하나의 결말로 이어졌습니다.','DLC 제안 · 본편의 약속을 기억하는 후일담과 새 사건.');}
 return portrait('g25','시즈쿠','성인 여우 요괴 · 비밀연애',speech,'SECRET / '+state.place)+'<div class="panel">'+progress()+content+'</div>';
}
function render(){
 allowed=new Set();const views={g21:workshop,g22:home,g23:salon,g24:rpg,g25:fox};const period=gameId==='g22'?state.day+' / 14일':gameId==='g25'?state.day+' / 7일':gameId==='g24'?'원정 01':'밤 05';
 root.innerHTML='<div class="screen '+themes[gameId]+'"><header class="hud"><div class="game-title"><small>PLAYABLE FLOW MOCKUP</small>'+titles[gameId]+'</div><div class="resources"><span>'+(gameId==='g21'?'제작 재료':'진행')+'<b>'+(gameId==='g21'?state.materials:period)+'</b></span><span>'+(gameId==='g23'?'골드':'관계')+'<b>'+(gameId==='g23'?state.gold+' G':'♥ '+state.affinity)+'</b></span><span>사진<b>'+state.album.length+'</b></span></div></header><div class="body">'+views[gameId]()+'</div><footer class="bottom-bar"><span>축약 1회 플레이 · 대화는 고정 시나리오</span>'+button('처음부터','reset')+'</footer><div class="status" role="status">'+state.notice+'</div></div>';
}
function act(action){
 if(!allowed.has(action))return;
 state.notice='';const [key,value,extra]=action.split(':');
 switch(key){
 case'reset':state=initial();break;
 case'source':state.editSlot=Number(value);break;
 case'origin':if(originFor(value)&&state.parents[1-state.editSlot]!==value)state.parents[state.editSlot]=value;break;
 case'gacha':{const drawn=pick(appearancePool);state.gacha=drawn.name;state.materials+=8;state.phase=1;state.notice='체험 가챠 획득 · '+drawn.name+' · 재료 +8';break;}
 case'collect':state.materials+=8;state.phase=1;break;
 case'combine':{if(state.materials<12)break;const ps=pools(),a=pick(ps.appearance),p=pick(ps.personality),t=pick(ps.trait);let inherited=false;if(state.savedTrait&&state.parents.includes('saved')&&Math.random()<combination().rate){inherited=true;if(state.savedTrait.kind==='personality')p.name=state.savedTrait.name;else t.name=state.savedTrait.name;}state.result={appearance:a.name,g:a.g,personality:p.name,trait:t.name};state.inherit=inherited;state.materials-=12;state.phase=2;break;}
 case'inherit-open':state.phase=3;break;
 case'inherit-save':{const ancestors=state.parents.map(k=>originFor(k).name);const nextOrigin={name:'파트너 #'+String(state.generation).padStart(2,'0'),base:appearancePool.findIndex(a=>a.g===state.result.g),factors:[state.result.appearance,state.result.personality,state.result.trait==='특별 특징 없음'?state.result.personality+' 인자':state.result.trait],lineage:ancestors};state.savedTrait=state.result.trait==='특별 특징 없음'?{kind:'personality',name:state.result.personality}:{kind:'trait',name:state.result.trait};state.savedOrigin=nextOrigin;state.phase=4;break;}
 case'workshop-meet':state.message='오늘 밤 함께 별 보기';state.affinity=Math.min(100,state.affinity+8);state.phase=5;break;
 case'workshop-album':saveScene('창가에서 별을',state.result.appearance+' · '+state.result.personality+' · '+state.message,state.result.g);state.phase=6;break;
 case'workshop-again':state.parents=['saved','1'];state.editSlot=1;state.generation++;state.materials+=12;state.result=null;state.message='';state.phase=1;state.notice='다음 회차 재료 +12 · 이전 파트너를 원형 A에 배치했습니다.';break;
 case'activity':state.activities[Number(value)]=extra;break;
 case'home-day':state.affinity+=5;state.phase=1;break;
 case'home-reply':state.preference=value;state.message=value==='sweet'?'나는 달콤한 맛을 좋아해.':'다음에도 함께 산책하고 싶어.';state.day=4;state.affinity+=8;state.phase=2;break;
 case'home-scene':state.phase=3;break;
 case'home-ending':saveScene(state.preference==='sweet'?'함께 만든 달콤한 저녁':'둘만의 산책',state.message);state.day=14;state.ending=state.preference==='sweet'?'우리의 식탁':'함께 걷는 내일';state.phase=4;break;
 case'witch':state.witch=value;break;
 case'salon-close':state.gold+=200;state.affinity=Math.min(100,state.affinity+5);state.phase=1;break;
 case'salon-reply':state.message=witches[state.witch].reply;state.affinity=Math.min(100,state.affinity+8);state.phase=2;break;
 case'salon-album':saveScene(witches[state.witch].scene,state.message,witches[state.witch].g);state.phase=3;break;
 case'salon-upgrade':if(state.gold<200)break;state.gold-=200;state.phase=4;break;
 case'salon-again':state.phase=0;state.notice='개인 응접실을 유지하고 다음 영업을 시작합니다.';break;
 case'companion':state.companion=value;break;
 case'rpg-start':state.phase=1;break;
 case'attack':case'guard':case'combo':case'heal':{let damage=0,retaliation=12;if(key==='attack')damage=25;if(key==='guard'){damage=15;retaliation=4;state.guarded=true;state.affinity=Math.min(100,state.affinity+3);}if(key==='combo'){if(!state.combo)break;damage=45;state.combo--;}if(key==='heal')state.hp=Math.min(100,state.hp+30);state.enemy=Math.max(0,state.enemy-damage);state.turn++;state.log={attack:'검격 · 피해 25',guard:'동료 엄호 · 피해 15 · 신뢰 +3',combo:'합동 기술 · 피해 45',heal:'회복 · 파티 HP +30'}[key];if(state.enemy===0){state.phase=2;state.gold+=120;state.affinity=Math.min(100,state.affinity+8);}else{state.hp=Math.max(0,state.hp-retaliation);state.log+='<br>파수꾼 반격 · '+retaliation+' 피해';if(state.hp===0)state.phase=5;}break;}
 case'rpg-talk':state.phase=3;break;
 case'rpg-album':saveScene(state.companion+(state.companion==='에린'?'과':'와')+' 야영지의 약속',state.guarded?'엄호한 기억 · '+companions[state.companion].quest:'함께 싸운 기억 · '+companions[state.companion].quest,companions[state.companion].g);state.phase=4;break;
 case'rpg-again':case'rpg-retry':state.phase=1;state.enemy=100;state.hp=100;state.combo=1;state.turn=1;state.guarded=false;state.log='새 원정 · 같은 파티로 출발했습니다.';break;
 case'fox-reply':state.preference=value;state.message=value==='accept'?'어떤 모습이어도 너는 너야.':'괜찮아. 천천히 말해줘.';state.affinity+=7;state.phase=1;break;
 case'fox-place':state.place=value;state.day=3;state.phase=2;break;
 case'fox-meet':state.affinity+=8;state.phase=3;break;
 case'fox-ending':saveScene(state.place+'에서 드러낸 비밀',state.message);state.day=7;state.ending=state.preference==='accept'?'너의 모든 모습':'기다려준 마음';state.phase=4;break;
 }
 render();
 if(typeof window.dispatchEvent==='function')window.dispatchEvent(new Event('game-render'));
}
root.addEventListener('click',e=>{const target=e.target.closest('button[data-action]');if(target&&!target.disabled)act(target.dataset.action);});
render();
