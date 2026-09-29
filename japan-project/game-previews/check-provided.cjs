const assert=require('node:assert/strict'),fs=require('node:fs'),path=require('node:path');
for(const g of ['g21','g22','g23','g24','g25']){
 const dir=path.join(__dirname,'provided',g),html=fs.readFileSync(path.join(dir,'mockup.html'),'utf8');
 assert.equal((html.match(/class="screen(?: on)?" id="s[0-5]"/g)||[]).length,6,g+' six scenes');
 for(const [,target] of html.matchAll(/data-go="([^"]+)"/g))assert.match(html,new RegExp('id="'+target+'"'),g+' reachable destination');
 for(const [,image] of html.matchAll(/src="(img\/[^"]+)"/g))assert.ok(fs.existsSync(path.join(dir,image)),g+' missing '+image);
 assert.match(html,/player.js/);assert.match(html,/id="autoBtn"/);assert.match(html,/id="resetBtn"/);
 for(const name of ["storyboard.png",...Array.from({length:6},(_,i)=>"step_0"+(i+1)+".png")])assert.ok(fs.existsSync(path.join(dir,name)));assert.doesNotMatch(html,/game-art\/|g2[1-5]-scenes/);
 const script=html.match(/<script>([\s\S]*?)<\/script>/)[1];const data=require('node:vm').runInNewContext(script.split("const tr=document")[0]+';({STEPS,CHATS,ORDER})');
 assert.equal(data.ORDER.length,6);assert.equal(data.STEPS.length,6);
}
const main=fs.readFileSync(path.join(__dirname,'../concept-drafts-5-variants.html'),'utf8');assert.doesNotMatch(main,/inheritance-reference|viewer.js|viewer.css/);
console.log('PASS: supplied 5 × 6 scenes, all transition targets and image assets, no discarded generated illustrations or reference essay.');
