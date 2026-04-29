// RoyalColorCollection.jsx — event popup. 4 design variations toggled via `variant` prop.
// Asset-free; uses Icon + SvgCard primitives.

const MILESTONE_COUNT = 14;

// Deterministic reward table (14 milestones)
// Types: g=gold, h=hammer, b=bomb, w=wild, u=undo
const REWARDS = [
  {type: 'g', amount: 100},
  {type: 'h', amount: 1},
  {type: 'g', amount: 200},
  {type: 'b', amount: 1},
  {type: 'g', amount: 300},
  {type: 'h', amount: 2},
  {type: 'w', amount: 1},
  {type: 'g', amount: 500},
  {type: 'u', amount: 1},
  {type: 'h', amount: 3},
  {type: 'g', amount: 800},
  {type: 'b', amount: 2},
  {type: 'w', amount: 2},
  {type: 'g', amount: 2000, grand: true}, // grand
];
// Required card count at each milestone (cumulative)
const THRESHOLDS = [3, 8, 15, 25, 40, 60, 85, 115, 150, 190, 240, 300, 380, 500];

// Part detection: Mon-Wed = part 1 (black), Thu-Sat = part 2 (red), Sun defaults to part 2
const detectPart = () => {
  const d = new Date().getUTCDay(); // 0=Sun
  return (d >= 1 && d <= 3) ? 1 : 2;
};

// Countdown ends at next UTC midnight Sunday (end of part 2) / Wed (end of part 1).
const getPartEndUTC = (part) => {
  const now = new Date();
  const d = new Date(Date.UTC(now.getUTCFullYear(), now.getUTCMonth(), now.getUTCDate(), 0, 0, 0));
  const day = now.getUTCDay();
  // Part 1 ends after Wed (day 3); part 2 ends after Sat (day 6)
  const targetDay = part === 1 ? 4 : 0; // Thu (day 4) or Sun (day 0) midnight UTC
  let diff = (targetDay - day + 7) % 7;
  if (diff === 0) diff = 7;
  d.setUTCDate(d.getUTCDate() + diff);
  return d.getTime();
};

const useCountdown = (endMs) => {
  const [now, setNow] = React.useState(Date.now());
  React.useEffect(() => {
    const t = setInterval(() => setNow(Date.now()), 1000);
    return () => clearInterval(t);
  }, []);
  const ms = Math.max(0, endMs - now);
  const days = Math.floor(ms / 86400000);
  if (days >= 1) return `${Math.min(days, 99)}days`;
  const h = Math.floor(ms / 3600000);
  const m = Math.floor((ms % 3600000) / 60000);
  const s = Math.floor((ms % 60000) / 1000);
  const pad = (n) => String(n).padStart(2, '0');
  return `${pad(h)}:${pad(m)}:${pad(s)}`;
};

// ---------- Reusable small pieces ----------

const RewardChip = ({reward, state, size = 54, grand = false}) => {
  // state: 'claimed' | 'next' | 'locked' | 'grand'
  const iconName = {g: 'coin', h: 'hammer', b: 'bomb', w: 'wild', u: 'undo'}[reward.type];
  const bg = state === 'claimed' ? 'linear-gradient(180deg,#2a9a40,#1a6028)'
    : state === 'next' ? 'linear-gradient(180deg,#ffde70,#e8a020)'
    : state === 'locked' ? 'linear-gradient(180deg,#4a4048,#2a2428)'
    : 'linear-gradient(180deg,#ffe070,#c08010)'; // grand
  const ring = state === 'next' ? '0 0 0 2px #fff, 0 0 18px rgba(255,224,120,.8)'
    : state === 'grand' ? '0 0 0 2px #fff, 0 0 24px rgba(255,64,90,.7)'
    : 'none';
  return (
    <div style={{
      width: size, height: size, borderRadius: grand ? 'var(--r-md)' : 999,
      background: bg,
      boxShadow: `var(--shadow-stamp-md), ${ring}`,
      display: 'flex', alignItems: 'center', justifyContent: 'center',
      position: 'relative',
      border: grand ? '2px solid #fff' : 'none',
      opacity: state === 'locked' ? 0.65 : 1,
    }}>
      <Icon name={iconName} size={size * 0.62} />
      {state === 'claimed' && (
        <div style={{position:'absolute', top:-4, right:-4,
          width: 20, height: 20, borderRadius: 999, background:'#2a9a40',
          border:'2px solid #fff', display:'flex', alignItems:'center', justifyContent:'center'}}>
          <svg width="10" height="10" viewBox="0 0 10 10"><path d="M2 5 L4 7 L8 3" stroke="#fff" strokeWidth="2" fill="none" strokeLinecap="round"/></svg>
        </div>
      )}
      {/* amount */}
      <div style={{position:'absolute', bottom:-6, right:-4,
        background: '#1a1014', color: '#fff', fontSize: 10, fontWeight: 800,
        padding: '2px 6px', borderRadius: 8, border: '1px solid #ffe070',
        fontFamily:'var(--font-display)'}}>
        ×{reward.amount}
      </div>
    </div>
  );
};

const CardGlyph = ({color = 'red', size = 48, tilt = 0}) => (
  <div style={{
    width: size, height: size * 1.38,
    borderRadius: 4,
    background: 'linear-gradient(135deg, #fff 0%, #f5e8c8 100%)',
    border: '2px solid #ffd86a',
    boxShadow: '0 3px 6px rgba(0,0,0,.4), inset 0 1px 0 rgba(255,255,255,.7)',
    display:'flex', alignItems:'center', justifyContent:'center',
    color: color === 'red' ? '#d8201c' : '#1a1a20',
    fontSize: size * 0.6, fontWeight: 900, fontFamily: 'Baloo 2',
    transform: `rotate(${tilt}deg)`,
  }}>{color === 'red' ? '♥' : '♠'}</div>
);

const CountdownBadge = ({endMs, accent = '#ffd86a'}) => {
  const label = useCountdown(endMs);
  return (
    <div style={{
      display:'inline-flex', alignItems:'center', gap: 6,
      background: 'rgba(0,0,0,.55)', color: accent,
      padding: '4px 12px', borderRadius: 999,
      fontFamily:'var(--font-display)', fontWeight: 800, fontSize: 13,
      border: `1px solid ${accent}`,
      fontVariantNumeric:'tabular-nums',
    }}>
      <svg width="12" height="12" viewBox="0 0 12 12"><circle cx="6" cy="6" r="5" stroke={accent} strokeWidth="1.2" fill="none"/><path d="M6 3 L6 6 L8.5 7" stroke={accent} strokeWidth="1.2" fill="none" strokeLinecap="round"/></svg>
      {label}
    </div>
  );
};

// Level difficulty color
const getDifficulty = (level) => {
  if (level <= 10) return {name: 'normal', c1: 'var(--brand-green-300)', c2: 'var(--brand-green-500)', border:'#1a6028'};
  if (level <= 25) return {name: 'hard', c1: '#ff6a5a', c2: '#c8281c', border:'#801810'};
  return {name: 'super hard', c1: '#b85ae8', c2: '#6a20a8', border:'#3a0868'};
};

const PlayLevelButton = ({level, onClick, size='lg', style}) => {
  const d = getDifficulty(level);
  const [pressed, setPressed] = React.useState(false);
  const sizes = {md: {padding: '12px 26px', fontSize: 16}, lg: {padding: '16px 38px', fontSize: 22}};
  return (
    <button
      onClick={onClick}
      onMouseDown={() => setPressed(true)} onMouseUp={() => setPressed(false)} onMouseLeave={() => setPressed(false)}
      style={{
        border: 0, cursor: 'pointer', borderRadius: 'var(--r-lg)',
        fontFamily: 'var(--font-display)', fontWeight: 800, color: '#fff',
        background: `linear-gradient(180deg, ${d.c1}, ${d.c2})`,
        boxShadow: pressed ? 'var(--shadow-stamp-sm)' : 'var(--shadow-stamp-lg), inset 0 2px 0 rgba(255,255,255,.3)',
        transform: pressed ? 'translateY(3px)' : 'translateY(0)',
        transition: 'all var(--dur-fast)',
        textShadow: '0 1px 0 rgba(0,0,0,.3)',
        letterSpacing: '.02em',
        ...sizes[size], ...style,
      }}>
      Level + {level.toLocaleString()}
      <div style={{fontSize: 10, opacity:.85, marginTop: 2, textTransform:'uppercase', letterSpacing:'.1em'}}>
        {d.name}
      </div>
    </button>
  );
};

// ========================================================================
//   VARIATION A — "Classic royal" (popup shell, black+gold+red accents)
// ========================================================================
const RoyalPopupA = ({part, progress, level, onClose, onPlay}) => {
  const accent = part === 1 ? '#fff' : '#ff5a5a';
  const bgCard = part === 1 ? '#1a1a20' : '#3a1016';
  const endMs = React.useMemo(() => getPartEndUTC(part), [part]);
  // derive milestone states
  const nextIdx = THRESHOLDS.findIndex(t => progress < t);
  const claimedIdx = nextIdx === -1 ? MILESTONE_COUNT : nextIdx;

  return (
    <div style={{position:'absolute', inset:0, background:'rgba(6,4,10,.82)', backdropFilter:'blur(6px)',
      display:'flex', alignItems:'center', justifyContent:'center', zIndex:200,
      animation:'fadeIn var(--dur-base)'}}>
      <div style={{
        width: 900, height: 580, position:'relative',
        background: `linear-gradient(180deg, ${bgCard}, #050305)`,
        border: '3px solid #ffd86a',
        borderRadius: 'var(--r-2xl)',
        boxShadow:'0 30px 80px rgba(0,0,0,.8), 0 0 0 6px rgba(255,216,106,.15), inset 0 0 60px rgba(255,216,106,.08)',
        animation:'popIn var(--dur-slow) var(--ease-out-back)', overflow:'hidden',
      }}>
        {/* Decorative suit glyphs in corners */}
        <div style={{position:'absolute', top: 40, left: 30, opacity: .06, fontSize: 120, color: accent, fontFamily:'Baloo 2', fontWeight:900}}>{part===1?'♣':'♥'}</div>
        <div style={{position:'absolute', bottom: 40, right: 30, opacity: .06, fontSize: 140, color: accent, fontFamily:'Baloo 2', fontWeight:900, transform:'rotate(180deg)'}}>{part===1?'♠':'♦'}</div>

        {/* Close */}
        <button onClick={onClose} style={{
          position:'absolute', top: 14, right: 14, width: 36, height: 36, border:0, borderRadius: 999,
          background:'#fff', boxShadow:'var(--shadow-stamp-md)', cursor:'pointer',
          display:'flex', alignItems:'center', justifyContent:'center',
        }}><Icon name="close" size={16} /></button>

        {/* Title + countdown */}
        <div style={{padding: '26px 40px 0', textAlign:'center'}}>
          <div style={{
            display:'inline-flex', alignItems:'center', gap: 12, marginBottom: 6,
          }}>
            <CardGlyph color={part===1?'black':'red'} size={32} tilt={-8} />
            <h1 style={{margin: 0, color:'#ffe070', fontSize: 38, fontFamily:'var(--font-display)', fontWeight:900,
              textShadow:'0 2px 0 #8a5a0c, 0 4px 10px rgba(0,0,0,.6)', letterSpacing:'.02em'}}>
              Royal Color Collection
            </h1>
            <CardGlyph color={part===1?'black':'red'} size={32} tilt={8} />
          </div>
          <div style={{color: accent, fontSize: 13, opacity:.85, marginBottom: 8}}>
            Part {part} · {part===1?'Collect BLACK cards':'Collect RED cards'}
          </div>
          <CountdownBadge endMs={endMs} />
        </div>

        {/* Event description */}
        <div style={{padding:'16px 50px 0', textAlign:'center', color:'#f5e8c8', fontSize: 14, fontWeight: 500}}>
          Clear levels to collect cards of the week's color and unlock royal rewards.
        </div>

        {/* Progress + gauge — curved style (option 3) */}
        <div style={{padding:'18px 50px 0', position:'relative'}}>
          <div style={{display:'flex', alignItems:'center', gap: 14, marginBottom: 8}}>
            <div style={{
              width: 56, height: 56, borderRadius: 12,
              background: part===1? 'linear-gradient(135deg,#2a2030,#0a0608)':'linear-gradient(135deg,#6a1018,#1a0608)',
              border:'2px solid #ffd86a',
              display:'flex', alignItems:'center', justifyContent:'center',
              boxShadow:'0 4px 0 rgba(0,0,0,.5)',
            }}>
              <div style={{color: part===1?'#fff':'#ff5a5a', fontSize: 28, fontWeight:900, fontFamily:'Baloo 2'}}>
                {part===1?'♠':'♥'}
              </div>
            </div>
            <div style={{flex: 1}}>
              <div style={{fontFamily:'var(--font-display)', color:'#ffe070', fontSize: 20, fontWeight:800}}>
                {progress} / {THRESHOLDS[MILESTONE_COUNT-1]} cards
              </div>
              <div style={{color:'#c8b896', fontSize: 12}}>
                Match open cards of this color to fill the gauge.
              </div>
            </div>
          </div>

          {/* Curved gauge */}
          <div style={{position:'relative', height: 90, margin:'4px -10px 0'}}>
            <svg viewBox="0 0 820 90" preserveAspectRatio="none" style={{width:'100%', height:'100%', position:'absolute', inset:0}}>
              <defs>
                <linearGradient id="gaugeFill" x1="0" y1="0" x2="1" y2="0">
                  <stop offset="0" stopColor="#ff6a20"/>
                  <stop offset="1" stopColor="#ffde70"/>
                </linearGradient>
              </defs>
              <path d="M20 65 Q 205 15 410 45 T 800 55" stroke="rgba(255,255,255,.12)" strokeWidth="10" fill="none" strokeLinecap="round"/>
              <path d="M20 65 Q 205 15 410 45 T 800 55" stroke="url(#gaugeFill)" strokeWidth="8" fill="none" strokeLinecap="round"
                strokeDasharray="1000"
                strokeDashoffset={1000 - Math.min(1, progress / THRESHOLDS[MILESTONE_COUNT-1]) * 1000}
                style={{transition:'stroke-dashoffset .6s ease-out', filter:'drop-shadow(0 0 6px rgba(255,222,112,.8))'}}/>
            </svg>
            {/* milestone dots positioned along curve */}
            {REWARDS.map((r, i) => {
              const xPct = (i / (MILESTONE_COUNT - 1));
              // approx y along curve
              const yPct = 0.55 - Math.sin(xPct * Math.PI) * 0.35;
              const state = i < claimedIdx ? 'claimed'
                : i === claimedIdx ? 'next'
                : r.grand ? 'grand' : 'locked';
              return (
                <div key={i} style={{
                  position:'absolute',
                  left: `${xPct * 96 + 2}%`, top: `${yPct * 100}%`,
                  transform: 'translate(-50%,-50%)',
                }}>
                  <RewardChip reward={r} state={state} size={r.grand ? 46 : 36} grand={r.grand} />
                  {r.grand && (
                    <div style={{position:'absolute', top:-18, left:'50%', transform:'translateX(-50%)',
                      background:'#ff4060', color:'#fff', fontSize: 9, fontWeight:900,
                      padding:'2px 6px', borderRadius: 4, whiteSpace:'nowrap', letterSpacing:'.08em'}}>GRAND</div>
                  )}
                </div>
              );
            })}
          </div>
        </div>

        {/* Mission description (2 lines) */}
        <div style={{padding:'18px 60px 0', textAlign:'center', color:'#c8b896', fontSize: 13, lineHeight: 1.5}}>
          <div style={{color:'#ffe070', fontWeight:700, marginBottom: 2}}>This week's mission</div>
          Each time you remove a {part===1?'black':'red'} card, you earn 1 point.<br/>
          Hit every milestone before the timer runs out for the grand prize.
        </div>

        {/* Play CTA */}
        <div style={{position:'absolute', bottom: 22, left: 0, right: 0, display:'flex', justifyContent:'center'}}>
          <PlayLevelButton level={level} onClick={onPlay} size="lg" />
        </div>
      </div>
    </div>
  );
};

// ========================================================================
//   VARIATION B — "Casino table" (felt green + cards fanned at top)
// ========================================================================
const RoyalPopupB = ({part, progress, level, onClose, onPlay}) => {
  const endMs = React.useMemo(() => getPartEndUTC(part), [part]);
  const nextIdx = THRESHOLDS.findIndex(t => progress < t);
  const claimedIdx = nextIdx === -1 ? MILESTONE_COUNT : nextIdx;
  const fillPct = Math.min(1, progress / THRESHOLDS[MILESTONE_COUNT-1]) * 100;

  return (
    <div style={{position:'absolute', inset:0, background:'rgba(6,20,12,.8)', backdropFilter:'blur(6px)',
      display:'flex', alignItems:'center', justifyContent:'center', zIndex:200}}>
      <div style={{
        width: 900, height: 580, position:'relative',
        background:'radial-gradient(ellipse at center top, #1a5028 0%, #0a2a14 70%)',
        border:'4px solid #8a5a0c',
        borderRadius: 'var(--r-2xl)',
        boxShadow:'0 30px 80px rgba(0,0,0,.9), inset 0 0 120px rgba(0,0,0,.6)',
        animation:'popIn var(--dur-slow) var(--ease-out-back)', overflow:'hidden',
      }}>
        <button onClick={onClose} style={{position:'absolute', top: 14, right: 14, width: 36, height: 36, border:0, borderRadius: 999, background:'#fff', cursor:'pointer', boxShadow:'var(--shadow-stamp-md)', display:'flex', alignItems:'center', justifyContent:'center', zIndex:5}}>
          <Icon name="close" size={16} /></button>

        {/* Fanned cards header */}
        <div style={{position:'absolute', top: -10, left: 0, right: 0, display:'flex', justifyContent:'center', gap: -20, zIndex:2}}>
          {[-18, -9, 0, 9, 18].map((deg, i) => {
            const suits = part===1 ? ['♣','♠','♣','♠','♣'] : ['♥','♦','♥','♦','♥'];
            return (
              <div key={i} style={{
                width: 78, height: 108, margin: '0 -18px',
                background:'#fff', borderRadius: 8, border:'2px solid #8a5a0c',
                boxShadow:'0 6px 10px rgba(0,0,0,.5)',
                transform:`rotate(${deg}deg) translateY(${Math.abs(deg)*0.5}px)`,
                display:'flex', alignItems:'center', justifyContent:'center',
                color: part===1?'#1a1a20':'#d8201c', fontSize: 44, fontWeight: 900, fontFamily:'Baloo 2',
              }}>{suits[i]}</div>
            );
          })}
        </div>

        <div style={{padding: '120px 40px 0', textAlign:'center'}}>
          <h1 style={{margin: '0 0 6px', color:'#ffe070', fontSize: 36, fontFamily:'var(--font-display)', fontWeight:900,
            textShadow:'0 2px 0 #6a3a08, 0 0 18px rgba(255,222,112,.5)'}}>
            Royal Color Collection
          </h1>
          <div style={{display:'flex', justifyContent:'center', gap: 10, alignItems:'center', marginBottom: 10}}>
            <div style={{color:'#f5e8c8', fontSize: 13}}>Part {part} · {part===1?'BLACK week':'RED week'}</div>
            <CountdownBadge endMs={endMs} />
          </div>

          <div style={{color:'#c0d0b0', fontSize: 13, marginBottom: 14}}>
            Clear levels to collect {part===1?'black':'red'} cards and claim royal rewards.
          </div>

          {/* Horizontal gauge with milestone dots */}
          <div style={{margin:'10px 20px 10px', position:'relative'}}>
            <div style={{height: 14, background:'rgba(0,0,0,.6)', borderRadius: 999,
              boxShadow:'inset 0 2px 4px rgba(0,0,0,.8)', position:'relative', overflow:'hidden'}}>
              <div style={{width: `${fillPct}%`, height:'100%',
                background:'linear-gradient(90deg, #ff6a20, #ffde70)',
                boxShadow: '0 0 12px rgba(255,222,112,.8)',
                transition:'width .6s ease-out'}} />
            </div>
            <div style={{position:'absolute', left: 0, right: 0, top: -20,
              display:'flex', justifyContent:'space-between'}}>
              {REWARDS.map((r, i) => {
                const state = i < claimedIdx ? 'claimed' : i === claimedIdx ? 'next' : r.grand ? 'grand' : 'locked';
                return <RewardChip key={i} reward={r} state={state} size={r.grand?44:32} grand={r.grand}/>;
              })}
            </div>
          </div>

          <div style={{marginTop: 36, color:'#f5e8c8', fontSize: 13, lineHeight: 1.5, padding:'0 40px'}}>
            <div style={{color:'#ffe070', fontWeight:700}}>This week's mission</div>
            Each {part===1?'black':'red'} card cleared fills your gauge.<br/>
            Keep a streak for bonus points in harder levels.
          </div>
        </div>

        <div style={{position:'absolute', bottom: 22, left: 0, right: 0, display:'flex', justifyContent:'center'}}>
          <PlayLevelButton level={level} onClick={onPlay} size="lg" />
        </div>
      </div>
    </div>
  );
};

// ========================================================================
//   VARIATION C — "Ladder" (left = event info, right = vertical milestone ladder)
// ========================================================================
const RoyalPopupC = ({part, progress, level, onClose, onPlay}) => {
  const endMs = React.useMemo(() => getPartEndUTC(part), [part]);
  const nextIdx = THRESHOLDS.findIndex(t => progress < t);
  const claimedIdx = nextIdx === -1 ? MILESTONE_COUNT : nextIdx;
  const accent = part === 1 ? '#ffffff' : '#ff6a6a';

  return (
    <div style={{position:'absolute', inset:0, background:'rgba(6,4,10,.82)', backdropFilter:'blur(6px)',
      display:'flex', alignItems:'center', justifyContent:'center', zIndex:200}}>
      <div style={{
        width: 900, height: 580, position:'relative', display:'flex',
        background:'linear-gradient(135deg, #0a0608 0%, #1a1016 100%)',
        border:'3px solid #ffd86a',
        borderRadius: 'var(--r-2xl)',
        boxShadow:'0 30px 80px rgba(0,0,0,.85)',
        animation:'popIn var(--dur-slow) var(--ease-out-back)', overflow:'hidden',
      }}>
        <button onClick={onClose} style={{position:'absolute', top: 14, right: 14, width: 36, height: 36, border:0, borderRadius: 999, background:'#fff', cursor:'pointer', boxShadow:'var(--shadow-stamp-md)', display:'flex', alignItems:'center', justifyContent:'center', zIndex:5}}>
          <Icon name="close" size={16} /></button>

        {/* LEFT — hero info */}
        <div style={{flex: 1.2, padding: '30px 32px', position:'relative',
          background: part===1
            ? 'radial-gradient(circle at 30% 30%, #2a2028 0%, transparent 70%)'
            : 'radial-gradient(circle at 30% 30%, #3a0a14 0%, transparent 70%)',
        }}>
          {/* Floating cards behind hero */}
          <div style={{position:'absolute', top: 40, right: 20, opacity: .35,
            transform:'rotate(12deg)'}}>
            <CardGlyph color={part===1?'black':'red'} size={70} />
          </div>
          <div style={{position:'absolute', top: 140, right: 70, opacity: .2,
            transform:'rotate(-18deg)'}}>
            <CardGlyph color={part===1?'black':'red'} size={60} />
          </div>

          <div style={{position:'relative', zIndex:2}}>
            <CountdownBadge endMs={endMs} accent={accent}/>
            <h1 style={{margin:'14px 0 6px', color:'#ffe070', fontSize: 34, fontFamily:'var(--font-display)', fontWeight:900,
              textShadow:'0 2px 0 #6a3a08, 0 0 20px rgba(255,222,112,.4)', lineHeight: 1.05}}>
              Royal Color<br/>Collection
            </h1>
            <div style={{color: accent, fontSize: 14, fontWeight:700, marginBottom: 12}}>
              Part {part} · {part===1?'Black Suits':'Red Suits'}
            </div>
            <div style={{color:'#f5e8c8', fontSize: 13, lineHeight: 1.5, marginBottom: 18}}>
              Clear levels to collect cards of this week's color and fill your royal reward track.
            </div>

            <div style={{
              background:'rgba(255,216,106,.08)', border:'1px solid rgba(255,216,106,.25)',
              borderRadius: 'var(--r-md)', padding:'10px 12px', margin:'0 0 16px',
            }}>
              <div style={{color:'#ffe070', fontSize: 11, fontWeight:700, textTransform:'uppercase', letterSpacing:'.1em', marginBottom: 2}}>
                Mission
              </div>
              <div style={{color:'#f5e8c8', fontSize: 13, lineHeight: 1.4}}>
                Each {part===1?'black':'red'} card cleared = 1 point.<br/>
                Reach 500 before Sunday UTC midnight.
              </div>
            </div>

            <div style={{display:'flex', alignItems:'center', gap: 12, marginBottom: 12}}>
              <div style={{
                fontFamily:'var(--font-display)', fontWeight:900, fontSize: 28, color:'#ffe070',
                fontVariantNumeric:'tabular-nums',
              }}>{progress}</div>
              <div style={{color:'#c8b896', fontSize: 12}}>
                / {THRESHOLDS[MILESTONE_COUNT-1]} cards collected
              </div>
            </div>

            <PlayLevelButton level={level} onClick={onPlay} size="md" style={{width:'100%'}} />
          </div>
        </div>

        {/* RIGHT — vertical ladder */}
        <div style={{flex: 1, padding: '20px 20px 20px 0', position:'relative'}}>
          <div style={{
            height: '100%', background:'rgba(0,0,0,.45)',
            borderRadius: 'var(--r-lg)', padding:'16px 14px',
            border:'1px solid rgba(255,216,106,.25)',
            overflow:'hidden', position:'relative',
          }}>
            <div style={{color:'#ffe070', fontSize: 13, fontWeight:800, textAlign:'center', marginBottom: 10,
              textTransform:'uppercase', letterSpacing:'.08em'}}>Reward Track</div>
            <div style={{height: 'calc(100% - 30px)', overflowY: 'auto', paddingRight: 6}}>
              {REWARDS.slice().reverse().map((r, _i) => {
                const i = MILESTONE_COUNT - 1 - _i;
                const state = i < claimedIdx ? 'claimed' : i === claimedIdx ? 'next' : r.grand ? 'grand' : 'locked';
                const req = THRESHOLDS[i];
                return (
                  <div key={i} style={{
                    display:'flex', alignItems:'center', gap: 10,
                    padding: '7px 6px', borderRadius: 8,
                    marginBottom: 4,
                    background: state==='next' ? 'rgba(255,222,112,.1)' : 'transparent',
                    border: state==='next' ? '1px solid rgba(255,222,112,.4)' : '1px solid transparent',
                  }}>
                    <div style={{
                      width: 22, textAlign:'center',
                      fontFamily:'var(--font-display)', fontSize: 11, fontWeight:800,
                      color: state==='locked' ? '#6a6060' : '#ffe070',
                    }}>{i+1}</div>
                    <RewardChip reward={r} state={state} size={32} grand={r.grand}/>
                    <div style={{flex:1}}>
                      <div style={{color:'#f5e8c8', fontSize: 11, fontWeight:700}}>
                        {r.grand ? 'GRAND' : `Milestone ${i+1}`}
                      </div>
                      <div style={{color:'#8a8478', fontSize: 10}}>
                        {req} cards
                      </div>
                    </div>
                    {state==='claimed' && <div style={{color:'#2a9a40', fontSize: 16}}>✓</div>}
                  </div>
                );
              })}
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

// ========================================================================
//   VARIATION D — "Minimal" (within current UI tone, just color-forward)
// ========================================================================
const RoyalPopupD = ({part, progress, level, onClose, onPlay}) => {
  const endMs = React.useMemo(() => getPartEndUTC(part), [part]);
  const nextIdx = THRESHOLDS.findIndex(t => progress < t);
  const claimedIdx = nextIdx === -1 ? MILESTONE_COUNT : nextIdx;
  const fillPct = Math.min(1, progress / THRESHOLDS[MILESTONE_COUNT-1]) * 100;
  const partColor = part === 1 ? '#1a1a20' : '#d8201c';

  return (
    <div style={{position:'absolute', inset:0, background:'rgba(31,43,82,.72)', backdropFilter:'blur(4px)',
      display:'flex', alignItems:'center', justifyContent:'center', zIndex:200}}>
      <div style={{
        width: 900, height: 580, position:'relative',
        background:'var(--paper-50)',
        borderRadius: 'var(--r-2xl)',
        boxShadow:'var(--shadow-drop-lg)',
        animation:'popIn var(--dur-slow) var(--ease-out-back)', overflow:'hidden',
      }}>
        {/* Colored header stripe by part */}
        <div style={{
          position:'absolute', top:0, left:0, right:0, height: 120,
          background: part === 1
            ? 'linear-gradient(135deg, #1a1a20 0%, #3a3038 100%)'
            : 'linear-gradient(135deg, #8a1018 0%, #d8201c 100%)',
        }}>
          {/* Suit pattern */}
          {Array(20).fill(0).map((_, i) => (
            <div key={i} style={{
              position:'absolute', top: (i%4)*34, left: (i*58)%920,
              color: 'rgba(255,255,255,.07)', fontSize: 30, fontWeight:900, fontFamily:'Baloo 2',
              transform: `rotate(${i*13}deg)`,
            }}>{part===1 ? (i%2?'♠':'♣') : (i%2?'♥':'♦')}</div>
          ))}
        </div>

        <button onClick={onClose} style={{position:'absolute', top: 14, right: 14, width: 36, height: 36, border:0, borderRadius: 999, background:'#fff', cursor:'pointer', boxShadow:'var(--shadow-stamp-md)', display:'flex', alignItems:'center', justifyContent:'center', zIndex:5}}>
          <Icon name="close" size={16} /></button>

        <div style={{position:'relative', padding: '22px 40px 0', color:'#fff', zIndex:2}}>
          <CountdownBadge endMs={endMs} accent="#ffe070"/>
          <h1 style={{margin:'10px 0 2px', fontSize: 34, fontFamily:'var(--font-display)', fontWeight:900,
            textShadow:'0 2px 0 rgba(0,0,0,.4)'}}>Royal Color Collection</h1>
          <div style={{fontSize: 14, opacity:.85}}>
            Part {part} · Collect {part===1?'BLACK':'RED'} cards to win royal rewards
          </div>
        </div>

        {/* Gauge card */}
        <div style={{
          position:'absolute', top: 150, left: 32, right: 32,
          background:'#fff', borderRadius: 'var(--r-xl)',
          padding:'18px 22px', boxShadow:'var(--shadow-stamp-md)',
        }}>
          <div style={{display:'flex', alignItems:'center', gap: 14, marginBottom: 10}}>
            <div style={{
              width: 52, height: 52, borderRadius: 10,
              background: part===1?'#1a1a20':'#fff',
              border: `2px solid ${partColor}`,
              display:'flex', alignItems:'center', justifyContent:'center',
              color: partColor, fontSize: 28, fontWeight:900, fontFamily:'Baloo 2',
              boxShadow:'0 3px 0 rgba(0,0,0,.2)',
            }}>{part===1?'♠':'♥'}</div>
            <div style={{flex: 1}}>
              <div style={{fontFamily:'var(--font-display)', fontSize: 22, fontWeight:800, color:'var(--ink-900)'}}>
                {progress} <span style={{color:'var(--ink-500)', fontSize: 14, fontWeight:600}}>/ {THRESHOLDS[MILESTONE_COUNT-1]} cards</span>
              </div>
              <div style={{color:'var(--ink-500)', fontSize: 12}}>
                {nextIdx === -1 ? 'All milestones claimed!' : `Next reward at ${THRESHOLDS[nextIdx]} cards`}
              </div>
            </div>
          </div>

          {/* gauge with milestone pips */}
          <div style={{position:'relative', margin:'18px 0 12px'}}>
            <div style={{height: 10, background:'#efe6d5', borderRadius:999, boxShadow:'inset 0 2px 3px rgba(0,0,0,.2)', overflow:'hidden'}}>
              <div style={{width: `${fillPct}%`, height:'100%',
                background:'linear-gradient(90deg, var(--brand-orange-400), var(--brand-orange-500))',
                transition:'width .6s ease-out'}} />
            </div>
            <div style={{position:'absolute', left: 0, right: 0, top: -18,
              display:'flex', justifyContent:'space-between'}}>
              {REWARDS.map((r, i) => {
                const state = i < claimedIdx ? 'claimed' : i === claimedIdx ? 'next' : r.grand ? 'grand' : 'locked';
                return <RewardChip key={i} reward={r} state={state} size={r.grand?40:28} grand={r.grand}/>;
              })}
            </div>
          </div>

          <div style={{marginTop: 20, color:'var(--ink-500)', fontSize: 13, lineHeight: 1.5,
            borderTop: '1px dashed var(--ink-300)', paddingTop: 10}}>
            <b style={{color:'var(--ink-900)'}}>Mission:</b> Each {part===1?'black':'red'} card you clear = 1 point.<br/>
            Rewards auto-claim on the milestone — check your inbox for a toast.
          </div>
        </div>

        <div style={{position:'absolute', bottom: 22, left: 0, right: 0, display:'flex', justifyContent:'center'}}>
          <PlayLevelButton level={level} onClick={onPlay} size="lg" />
        </div>
      </div>
    </div>
  );
};

// ========================================================================
//   Wrapper + Toast
// ========================================================================
const RoyalColorCollection = ({variant = 'A', part, progress, level, onClose, onPlay}) => {
  const Comp = {A: RoyalPopupA, B: RoyalPopupB, C: RoyalPopupC, D: RoyalPopupD}[variant] || RoyalPopupA;
  return <Comp part={part} progress={progress} level={level} onClose={onClose} onPlay={onPlay}/>;
};

const ClaimToast = ({reward, onDone}) => {
  React.useEffect(() => {
    const t = setTimeout(onDone, 2600);
    return () => clearTimeout(t);
  }, [onDone]);
  if (!reward) return null;
  return (
    <div style={{
      position:'absolute', top: 84, left: '50%', transform: 'translateX(-50%)', zIndex: 300,
      background:'linear-gradient(180deg,#ffe070,#e8a020)',
      color:'#3a1a04', padding:'10px 16px 10px 12px', borderRadius: 999,
      boxShadow:'var(--shadow-stamp-lg), 0 0 20px rgba(255,222,112,.7)',
      display:'flex', alignItems:'center', gap: 10,
      fontFamily:'var(--font-display)', fontWeight:800, fontSize: 14,
      animation:'popIn .4s var(--ease-out-back)',
      border:'2px solid #fff',
    }}>
      <RewardChip reward={reward} state="claimed" size={32}/>
      <span>Milestone claimed · +{reward.amount} {reward.type==='g'?'gold':reward.type==='h'?'hammer':reward.type}</span>
    </div>
  );
};

Object.assign(window, {
  RoyalColorCollection, ClaimToast, detectPart, getPartEndUTC,
  MILESTONE_COUNT, REWARDS, THRESHOLDS, getDifficulty, PlayLevelButton,
});
