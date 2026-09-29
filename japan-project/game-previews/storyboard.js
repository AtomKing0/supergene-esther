const requested=new URLSearchParams(location.search).get('game');
const id=['g21','g22','g23','g24','g25'].includes(requested)?requested:'g21';
const artBase=document.currentScript?new URL('../assets/game-art/',document.currentScript.src).href:'../assets/game-art/';
const art=g=>artBase+g+'.png';
const choice=(text,selected=false)=>'<span class="static-control '+(selected?'selected':'')+'">'+text+'</span>';
const reward=text=>'<div class="story-reward">'+text+'</div>';
const memory=text=>'<div class="story-memory"><b>기억한 사건</b>'+text+'</div>';
const chat=(speaker,text,mine=false)=>'<div class="story-chat '+(mine?'mine':'')+'"><small>'+speaker+'</small>'+text+'</div>';
const image=(title,g)=>'<figure class="story-album"><img src="'+art(g)+'" alt="'+title+'의 참고 일러스트"><figcaption>'+title+'<small>상황 이미지 목업 · 참고 일러스트 재사용</small></figcaption></figure>';
const stats=text=>'<div class="story-stats">'+text+'</div>';
const intro=(title,text)=>'<div class="story-title">'+title+'</div><p>'+text+'</p>'+choice('게임 시작',true);
const games={
 g21:{title:'계승 공방',theme:'workshop',tag:'F2P + IAP · 확률 합성·승계',summary:'원형 수집 → 확률 합성 → 특징 승계 → 대화·약속 → 만남 이미지·앨범',cards:[
  {step:'01',title:'원형을 수집한다',scene:'공방 의뢰',name:'세라',ui:stats('제작 재료 18 → 26')+'<div class="story-puzzle">'+Array.from({length:24},(_,i)=>'<i class="'+([0,1,6,7,12,13,14,18,19,20,21,22].includes(i)?'filled':'')+'"></i>').join('')+'</div>'+choice('마지막 블록 놓기',true)+reward('의뢰 완료 · 마족형 원형 +1')},
  {step:'02',title:'외형·성격을 확률 합성',scene:'합성 결과 예시',name:'세라',ui:'<div class="story-parents"><span>마족형</span><b>＋</b><span>안드로이드형</span></div><div class="story-odds"><b>외형</b> 마족 50% · 안드로이드 35% · 여우 15%<br><b>성격</b> 호기심 50% · 다정함 30% · 도도함 20%<br><b>특징</b> 없음 70% · 은빛 날개 20% · 별빛 눈동자 10%</div>'+choice('합성 · 재료 12 소모',true)+reward('예시 결과 · 마족형 / 다정함 / 은빛 날개')},
  {step:'03',title:'희귀 특징을 승계 후보로',scene:'다음 조합 준비',name:'세라',ui:stats('보관한 후보 · 은빛 날개')+choice('승계 후보 보관',true)+'<div class="story-odds"><b>다음 합성에서 발현 60% · 미발현 40%</b><br>미발현 시 기본 확률로 추첨.<br>원형 본체는 소모하지 않는다.</div>'+memory('현재 파트너는 그대로 보관.<br>대화와 앨범도 파트너별로 유지.')},
  {step:'04',title:'대화로 첫 약속을 만든다',scene:'파트너와 첫 대화',name:'세라',ui:chat('나','오늘 밤, 같이 별을 볼까?',true)+chat('세라 · 다정함','네가 좋아하는 시간을 함께하고 싶어.')+memory('오늘 밤 함께 별 보기')+stats('관계 ♥ 24 → 32')},
  {step:'05',title:'약속을 기억한 만남',scene:'창가의 밤',name:'세라',ui:chat('세라','별을 좋아한다고 했지.<br>오늘은 내가 먼저 기다렸어.')+image('창가에서 별을','g21')},
  {step:'06',title:'특별 앨범 · 다음 합성',scene:'파트너 앨범',name:'세라',ui:image('세라 #01 · 첫 약속의 밤','g21')+memory('마족형 · 다정함 · 은빛 날개<br>함께 지킨 약속 · 별 보기')+reward('다음 합성에 승계 후보 적용<br>이 파트너의 대화 기억은 유지')}
 ]},
 g22:{title:'14일의 비밀 동거',theme:'home',tag:'본편 구매 + DLC · 관계 육성',summary:'하루 두 칸 → 취향 대화 → 다음 날의 제안 → 관계 이미지 → 14일 엔딩',cards:[
  {step:'01',title:'14일의 동거를 시작한다',scene:'우리의 방',name:'유나',ui:intro('14일의 비밀 동거','함께할 하루를 고르고,<br>나를 기억하는 파트너와 가까워진다.')+stats('파트너 1명 · 게임 안에서 날짜 진행')},
  {step:'02',title:'하루 두 칸의 활동 선택',scene:'DAY 03 · 아침',name:'유나',ui:stats('오전 · 요리 / 저녁 · 휴식')+'<div class="story-choices">'+choice('요리',true)+choice('외출')+choice('독서')+choice('휴식',true)+'</div>'+choice('이 일정으로 하루 보내기',true)+reward('함께 만든 저녁이 대화의 소재가 된다.')},
  {step:'03',title:'그 상황에서 취향을 알려준다',scene:'DAY 03 · 저녁',name:'유나',ui:chat('유나','같이 만든 저녁이 좋았어.<br>다음에는 네가 좋아하는 걸 해보고 싶어.')+chat('나','나는 달콤한 맛을 좋아해.',true)+memory('함께한 활동 · 요리와 휴식<br>내 취향 · 달콤한 맛')},
  {step:'04',title:'다음 날, 그녀가 먼저 제안',scene:'DAY 04 · 기억한 취향',name:'유나',ui:chat('유나','네가 좋아하는 달콤한 간식을 준비했어.<br>오늘도 같이 먹자.')+choice('그녀의 제안 받아들이기',true)+stats('관계 ♥ 29 → 37')},
  {step:'05',title:'관계 전환점 · 상황 이미지',scene:'DAY 04 · 둘만의 저녁',name:'유나',ui:image('함께 만든 달콤한 저녁','g22')+memory('어제 말한 취향이 오늘의 만남으로 이어졌다.')},
  {step:'06',title:'14일째 엔딩 · 추억 앨범',scene:'DAY 14 · 우리의 식탁',name:'유나',ui:image('엔딩 · 우리의 식탁','g22')+chat('유나','내일도 너와 함께하고 싶어.')+reward('본편 완결 · 취향과 약속을 보관<br>DLC: 기억을 이어가는 연인 후일담')}
 ]},
 g23:{title:'마녀의 비밀 살롱',theme:'salon',tag:'본편 구매 + DLC · 영업과 사적 관계',summary:'마녀 선택 → 짧은 영업 → 폐점 후 비밀 → 특별 예약 이미지 → 앨범·살롱 확장',cards:[
  {step:'01',title:'비밀 살롱에 들어간다',scene:'밤에만 여는 살롱',name:'리엘',ui:intro('마녀의 비밀 살롱','영업 중에는 동료,<br>문을 닫은 뒤에는 나만 아는 그녀.')+stats('리엘 · 조향 / 모르나 · 연금술 / 루나 · 응대')},
  {step:'02',title:'마녀를 골라 영업 배정',scene:'NIGHT 05 · 영업 중',name:'리엘',ui:'<div class="story-choices">'+choice('리엘 · 조향',true)+choice('모르나 · 연금술')+choice('루나 · 응대')+'</div>'+stats('조향 주문 120 G + 단골 주문 80 G')+choice('리엘에게 배정 · 영업 마치기',true)+reward('영업 수익 +200 G · 골드 360 → 560')},
  {step:'03',title:'폐점 후, 그녀의 비밀',scene:'CLOSED · 둘만의 대화',name:'리엘',ui:chat('리엘','언젠가 내 이름을 건 향수를 만들고 싶어.')+chat('나','네가 만든 향은 오래 기억하고 싶어.',true)+memory('함께한 영업 · 리엘의 꿈과 내 답장')},
  {step:'04',title:'나만을 위한 특별 예약',scene:'PRIVATE · 비밀 향수',name:'리엘',ui:chat('리엘','다음 예약은 너를 위해 비워둘게.')+image('리엘의 비밀 향수','g23')},
  {step:'05',title:'사진과 비밀을 앨범에',scene:'리엘의 특별 앨범',name:'리엘',ui:image('둘만의 예약 · 첫 사진','g23')+memory('리엘의 꿈 · 자기 이름을 건 향수<br>함께 지킨 비밀 · 나만을 위한 예약')},
  {step:'06',title:'수익으로 다음 만남을 연다',scene:'새 개인 응접실',name:'리엘',ui:stats('골드 560 → 360 · 확장 비용 200 G')+choice('개인 응접실 개방',true)+chat('리엘','이 공간에서는 우리 이야기만 하자.')+reward('다음 영업 → 새 만남<br>DLC: 새 마녀와 특별 예약 테마')}
 ]},
 g24:{title:'왕도 계약 조사대',theme:'rpg',tag:'본편 구매 + DLC · 동료 공략 RPG',summary:'두 명의 동료 → 짧은 원정 → 전투 기억 대화 → 개인 의뢰·야영 이미지 → 다음 원정',cards:[
  {step:'01',title:'왕도 조사대에 합류한다',scene:'왕도의 의뢰소',name:'에린',ui:intro('왕도 계약 조사대','함께 싸운 선택을 기억하고,<br>귀환 후 다른 면을 보여주는 동료들.')+stats('인간 기사 · 엘프 사수 · 마족 마법사')},
  {step:'02',title:'취향에 맞는 동료 선택',scene:'2인 파티 편성',name:'에린',ui:stats('고정 동료 · 리아 / 인간 기사')+'<div class="story-choices">'+choice('에린 · 엘프 사수',true)+choice('벨라 · 마족 마법사')+'</div>'+choice('리아 + 에린 · 원정 출발',true)+reward('엄호 담당 기사와 사수의 합동 기술')},
  {step:'03',title:'짧은 턴제 원정을 완료',scene:'왕도 외곽 · 마지막 전투',name:'에린',ui:stats('파수꾼 HP 100 → 0')+'<div class="story-choices">'+choice('엄호 · 사수 보호',true)+choice('합동 기술 · 피해 45')+choice('검격 · 피해 25')+choice('회복 · HP +30')+'</div>'+memory('리아가 에린을 엄호했다.')+reward('VICTORY · 골드 +120 · 신뢰 +8')},
  {step:'04',title:'귀환 후, 그 선택을 기억',scene:'RETURN · 에린과 대화',name:'에린',ui:chat('에린','아까 나를 보호해준 거, 기억하고 있어.')+chat('나','네가 무사해서 다행이야.',true)+reward('에린의 개인 의뢰 · 숲 조사 해금')},
  {step:'05',title:'야영에서 둘만의 약속',scene:'CAMP · 야영지',name:'에린',ui:image('에린과 야영지의 약속','g24')+memory('엄호한 기억 · 다음 원정도 함께하기')},
  {step:'06',title:'원정 앨범 · 다음 개인 의뢰',scene:'숲 조사 준비',name:'에린',ui:image('함께 싸운 기록 · 야영 사진','g24')+choice('현재 파티로 숲 조사 출발',true)+reward('다음 원정으로 관계와 서사를 이어감<br>DLC: 새 동료와 개인 의뢰')}
 ]},
 g25:{title:'요괴와의 7일간 비밀연애',theme:'fox',tag:'본편 구매 + DLC · 메시지 연애 ADV',summary:'낮의 비밀 메시지 → 만남 선택 → 답장을 기억 → 밤의 정체 공개 → 7일 엔딩',cards:[
  {step:'01',title:'7일의 비밀연애를 시작',scene:'낮에는 평범한 그녀',name:'시즈쿠',ui:intro('7일간 비밀연애','낮에는 비밀 메시지,<br>밤에는 나만 아는 그녀의 본모습.')+stats('성인 여우 요괴 · 실제 시간 대기 없음')},
  {step:'02',title:'낮의 메시지로 비밀을 나눈다',scene:'DAY 02 · 비밀 연락',name:'시즈쿠',ui:chat('시즈쿠','정체를 들킬 뻔했어.<br>너에게만 이야기하고 싶었어.')+chat('나','어떤 모습이어도 너는 너야.',true)+memory('내 답장 · 본모습을 받아들이기')},
  {step:'03',title:'그날의 만남을 정한다',scene:'DAY 02 · 밤의 약속',name:'시즈쿠',ui:chat('시즈쿠','안심했어. 오늘 밤 만나줄래?')+'<div class="story-choices">'+choice('조용한 옥상',true)+choice('밤의 정원')+'</div>'+memory('만남 장소 · 옥상')},
  {step:'04',title:'다음 대화에서 어제 말을 기억',scene:'DAY 03 · 약속을 확인',name:'시즈쿠',ui:chat('시즈쿠','어떤 모습이어도 나라고 했지.<br>그 말을 믿어볼게.')+memory('어제의 답장과 옥상 약속')+choice('옥상에서 밤의 만남으로',true)},
  {step:'05',title:'밤의 만남 · 정체 공개',scene:'DAY 03 · 나만 아는 본모습',name:'시즈쿠',ui:chat('시즈쿠','그 말을 믿고, 오늘은 숨기지 않을게.')+image('옥상에서 드러낸 비밀','g25')},
  {step:'06',title:'7일째 엔딩 · 둘만의 앨범',scene:'DAY 07 · 너의 모든 모습',name:'시즈쿠',ui:image('엔딩 · 너의 모든 모습','g25')+chat('시즈쿠','이제 네 앞에서는 숨기지 않아도 되겠지.')+reward('본편 완결 · 비밀과 약속을 보관<br>DLC: 관계 기억을 이어가는 후일담')}
 ]}
};
function drawBoard(root,id){const game=games[id];
root.innerHTML='<section class="storyboard-mode '+game.theme+'"><header class="storyboard-heading"><div><small>'+game.tag+'</small><h1>'+game.title+'</h1></div><span>PLAY FLOW · 6 SCENES</span></header><p class="storyboard-summary">'+game.summary+'</p><ol class="storyboard-grid">'+game.cards.map(c=>'<li class="story-card"><header><b>'+c.step+'</b><h2>'+c.title+'</h2></header><div class="story-scene"><img src="'+art(id)+'" alt="'+c.name+' 참고 일러스트"><span>'+c.scene+'</span><strong>'+c.name+'</strong></div><div class="story-interface">'+c.ui+'</div></li>').join('')+'</ol><p class="storyboard-note">한 경로를 나열한 UI 목업. 대화는 고정 예시, 이미지는 참고 일러스트입니다.'+(id==='g21'?' 확률은 설계 예시이며 출시 수치가 아닙니다.':id==='g22'?' 5~13일은 생략해 엔딩까지 연결했습니다.':id==='g25'?' 4~6일은 생략해 엔딩까지 연결했습니다.':'')+'</p></section>';
}
const inlineBoards=document.querySelectorAll('[data-storyboard-game]');
if(inlineBoards.length){for(const root of inlineBoards)drawBoard(root,root.dataset.storyboardGame);}else drawBoard(document.getElementById('storyboard'),id);
