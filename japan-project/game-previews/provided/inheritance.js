(() => {
 let selected=1,parents=[0,1],saved='';const files=['charA.jpg','charB.jpg','charC.jpg'];
 const chances=()=>parents.includes(2)?[45,10,45]:[50,35,15];
 function redraw(){document.querySelectorAll('.source-slot').forEach((b,i)=>{b.classList.toggle('pick',i===selected);b.querySelector(':scope>img').src='img/'+files[parents[i]];b.querySelector('b').textContent='원형 '+String.fromCharCode(65+parents[i]);});const p=chances();document.getElementById('compatibility').textContent=parents.includes(2)?'상성 ○':'상성 ◎';document.getElementById('fusion-odds').innerHTML='외형 A '+p[0]+'% · B '+p[1]+'% · C '+p[2]+'%<br>성격·희귀 특징 별도 추첨'+(saved?'<br>보관 인자 · '+saved:'');}
 document.querySelectorAll('[data-slot]').forEach(b=>b.onclick=()=>{selected=Number(b.dataset.slot);redraw();});
 document.querySelectorAll('[data-origin]').forEach(b=>b.onclick=()=>{const i=Number(b.dataset.origin);if(i!==parents[1-selected])parents[selected]=i;redraw();});
 document.querySelector('[data-gacha]').onclick=()=>{const i=Math.floor(Math.random()*3);document.querySelector('#s1 .toast').textContent='가챠 결과 · 원형 '+String.fromCharCode(65+i);parents=[i,(i+1)%3];redraw();};
 document.querySelector('#s2 [data-go]').addEventListener('click',()=>{const p=chances(),r=Math.random()*100,i=r<p[0]?0:r<p[0]+p[1]?1:2;saved=Math.random()<.3?'희귀 인자':'기본 인자';document.getElementById('fusion-result').textContent='외형 '+String.fromCharCode(65+i)+' · '+['다정함','호기심','도도함'][Math.floor(Math.random()*3)]+' · '+saved;});
 redraw();
})();
