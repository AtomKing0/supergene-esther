const assert=require('node:assert/strict'),fs=require('node:fs'),vm=require('node:vm');
(async()=>{
 for(const game of ['g21','g22','g23','g24','g25']){
  const html=fs.readFileSync(__dirname+'/provided/'+game+'/mockup.html','utf8');
  const source=html.slice(html.indexOf('async function onEnter('),html.indexOf('function next('));
  for(const type of ['title','chat','scene','battle']){
   let advance=0;const pending=[],elements=new Map();
   const element=()=>({children:[],style:{},classList:{add(){},remove(){}},appendChild(x){this.children.push(x)}});
   const document={getElementById:id=>{if(!elements.has(id))elements.set(id,element());return elements.get(id)},createElement:element};
   const context=vm.createContext({auto:true,flowRun:1,TYPES:{s0:type},CHATS:{s0:[['','첫 대화'],['me','답장']]},document,sleep:()=>new Promise(resolve=>pending.push(resolve)),W:(_,fallback)=>fallback,next:()=>advance++});
   vm.runInContext(source,context);const running=vm.runInContext("onEnter('s0')",context);
   assert.equal(pending.length,1);
   vm.runInContext('auto=false;flowRun++;',context);pending.shift()();await running;
   assert.equal(advance,0,game+' '+type+' must not advance after stopping');
  }
  // Restarting autoplay must not revive an old pending transition.
  const pending=[];let advance=0;
  const context=vm.createContext({auto:true,flowRun:1,TYPES:{s0:'choice'},document:{getElementById:()=>({classList:{remove(){}}})},sleep:()=>new Promise(resolve=>pending.push(resolve)),W:(_,fallback)=>fallback,next:()=>advance++});
  vm.runInContext(source,context);const running=vm.runInContext("onEnter('s0')",context);
  vm.runInContext('flowRun+=2;auto=true',context);pending.shift()();await running;assert.equal(advance,0,game+' stale timer after restart');
 }
 console.log('PASS: 5 players cancel pending title/chat/image/battle transitions; restarting cannot revive old timers.');
})().catch(error=>{console.error(error);process.exitCode=1});
