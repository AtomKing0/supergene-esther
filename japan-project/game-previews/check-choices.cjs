const assert=require('node:assert/strict'),fs=require('node:fs'),vm=require('node:vm');
const source=fs.readFileSync(__dirname+'/provided/player.js','utf8');
const routeCode=source.slice(source.indexOf("if(gameId==='g25')"),source.indexOf("if(gameId==='g23')"));
const elements=new Map(),options=[{},{},{}],get=s=>{if(!elements.has(s))elements.set(s,{});return elements.get(s);};
const context={gameId:'g25',conversationContext:'',CHATS:{},STEPS:Array.from({length:6},()=>({})),document:{querySelectorAll:()=>options},choiceButton:(el,action)=>{el.click=action;return el;},markChoice:(el,on)=>el.selected=on,textAt:(s,t)=>get(s).textContent=t,imageAt:(s,f)=>get(s).src=f};
vm.runInNewContext(routeCode,context);
for(let i=0;i<3;i++){
 options[i].click();assert.deepEqual(options.map(e=>e.selected),options.map((_,j)=>j===i));
 assert(context.CHATS.s3[0][1]);assert(get('#s4img img').src);assert(get('#s5 .h').textContent);
 if(i===2){assert.match(get('#s3btn').textContent,/메시지/);assert.match(get('#s4cap').textContent,/직접 만나지 않았다/);assert.equal(get('#s4img img').src,'avatar_day.jpg');}
 else assert.match(get('#s3btn').textContent,/만남/);
}
assert(!/innerHTML\s*=.*message/.test(source),'Typed messages must be inserted as text');
console.log('PASS: all 3 meeting choices update selected state, next dialogue, image, and outcome; no-meeting route stays remote.');
