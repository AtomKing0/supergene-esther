const assert=require('node:assert/strict'),fs=require('node:fs'),vm=require('node:vm');
let playing=false,notify;
const autoplayStatus={hidden:false},controls={classList:{contains:()=>playing}};
const source=fs.readFileSync(__dirname+'/provided/player.js','utf8').split('const suppliedControls=')[1];
vm.runInNewContext('const suppliedControls='+source,{autoplayStatus,document:{getElementById:()=>controls},MutationObserver:class{constructor(fn){notify=fn}observe(){}}});
assert.equal(autoplayStatus.hidden,true);
playing=true;notify();assert.equal(autoplayStatus.hidden,false);
playing=false;notify();assert.equal(autoplayStatus.hidden,true);
console.log('PASS: autoplay status appears on start and disappears on completion/reset.');
