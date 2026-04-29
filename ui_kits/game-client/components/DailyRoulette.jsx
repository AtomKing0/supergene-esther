// DailyRoulette — 3 variations, 8 sectors, free-spin + ad states, winning flow animations.
// A: classic carnival wheel (red/gold, rope-edge)
// B: royal / casino (black + gold + crimson)
// C: current-brand (orange/peach, friendly cartoon)

const ROULETTE_REWARDS = [
  {type: 'gold',   amount: 500,   color: '#f5c040', label: '500'},
  {type: 'hammer', amount: 1,     color: '#7fb3e8', label: '×1'},
  {type: 'bomb',   amount: 2,     color: '#4a4a52', label: '×2'},
  {type: 'gold',   amount: 1500,  color: '#f5c040', label: '1.5K'},
  {type: 'ticket', amount: 1,     color: '#ff8a4a', label: '×1'},
  {type: 'undo',   amount: 3,     color: '#4b7bc4', label: '×3'},
  {type: 'gold',   amount: 300,   color: '#f5c040', label: '300'},
  {type: 'wild',   amount: 1,     color: '#b060e8', label: '×1'},
];

const REWARD_ICON = {
  gold: 'coin', hammer: 'hammer', bomb: 'bomb', ticket: 'ticket',
  undo: 'undo', wild: 'wild',
};

const rewardLabel = (r) =>
  r.type === 'gold' ? `${r.amount.toLocaleString()} Gold` :
  r.type === 'hammer' ? `${r.amount} Hammer` :
  r.type === 'bomb' ? `${r.amount} Bomb Booster` :
  r.type === 'ticket' ? `Free Entry Ticket` :
  r.type === 'undo' ? `${r.amount} Undo Booster` :
  r.type === 'wild' ? `${r.amount} Wild Booster` :
  r.type;

// ---------- Wheel (variation-agnostic core) ----------
const Wheel = ({size = 360, rewards = ROULETTE_REWARDS, angle = 0, theme, spinning, onRest, winningFlow = 'highlight', landed}) => {
  const n = rewards.length;
  const per = 360 / n;
  return (
    <div style={{
      position: 'relative', width: size, height: size,
      filter: 'drop-shadow(0 12px 24px rgba(0,0,0,.4))',
    }}>
      {/* Outer rim (studded) */}
      <div style={{
        position: 'absolute', inset: 0, borderRadius: '50%',
        background: theme.rimGradient,
        boxShadow: theme.rimShadow,
        padding: size * 0.04,
      }}>
        {/* Studs */}
        <svg viewBox="-100 -100 200 200" style={{position:'absolute', inset:0, width:'100%', height:'100%'}}>
          {Array.from({length: 16}).map((_,i) => {
            const a = (i/16) * Math.PI*2;
            const r = 94;
            const cx = Math.cos(a) * r, cy = Math.sin(a) * r;
            return <circle key={i} cx={cx} cy={cy} r={3} fill={theme.studFill} stroke={theme.studStroke} strokeWidth={0.6} />;
          })}
        </svg>

        {/* Spinning disc */}
        <div style={{
          position: 'relative', width: '100%', height: '100%', borderRadius: '50%',
          background: theme.discBg,
          transform: `rotate(${angle}deg)`,
          transition: spinning ? 'transform 4200ms cubic-bezier(.17,.67,.25,1)' : 'none',
          overflow: 'hidden',
          boxShadow: 'inset 0 0 0 4px ' + theme.innerRing + ', inset 0 0 40px rgba(0,0,0,.25)',
        }}
        onTransitionEnd={() => spinning && onRest && onRest()}
        >
          {/* Sectors */}
          <svg viewBox="-100 -100 200 200" style={{position:'absolute', inset:0, width:'100%', height:'100%'}}>
            {rewards.map((r, i) => {
              const a0 = (i * per - 90 - per/2) * Math.PI/180;
              const a1 = ((i+1) * per - 90 - per/2) * Math.PI/180;
              const x0 = Math.cos(a0)*100, y0 = Math.sin(a0)*100;
              const x1 = Math.cos(a1)*100, y1 = Math.sin(a1)*100;
              const fill = theme.sectorFill ? theme.sectorFill(i) : (i%2 ? theme.sectorA : theme.sectorB);
              const isWin = winningFlow === 'highlight' && landed === i;
              return (
                <g key={i}>
                  <path d={`M0 0 L${x0} ${y0} A100 100 0 0 1 ${x1} ${y1} Z`}
                    fill={fill} stroke={theme.sectorStroke} strokeWidth="0.7" />
                  {isWin && (
                    <path d={`M0 0 L${x0} ${y0} A100 100 0 0 1 ${x1} ${y1} Z`}
                      fill="rgba(255,255,255,.45)">
                      <animate attributeName="fill"
                        values="rgba(255,255,255,.1);rgba(255,255,255,.55);rgba(255,255,255,.1)"
                        dur="0.7s" repeatCount="indefinite" />
                    </path>
                  )}
                </g>
              );
            })}
          </svg>

          {/* Sector labels/icons */}
          {rewards.map((r, i) => {
            const mid = i * per;
            const rad = size * 0.34;
            return (
              <div key={i} style={{
                position: 'absolute', left: '50%', top: '50%',
                transform: `rotate(${mid}deg) translate(0, -${rad}px) rotate(${-mid}deg) translate(-50%,-50%)`,
                width: size*0.2, display:'flex', flexDirection:'column', alignItems:'center', gap: 2,
                pointerEvents: 'none',
              }}>
                <div style={{filter:'drop-shadow(0 1px 2px rgba(0,0,0,.35))'}}>
                  <Icon name={REWARD_ICON[r.type]} size={size*0.11} />
                </div>
                <div style={{
                  fontFamily:'var(--font-display)', fontWeight: 900,
                  fontSize: size*0.055, color: theme.labelColor,
                  textShadow: theme.labelShadow, letterSpacing: '.02em',
                }}>{r.label}</div>
              </div>
            );
          })}

          {/* Spoke lines */}
          <svg viewBox="-100 -100 200 200" style={{position:'absolute', inset:0, width:'100%', height:'100%', pointerEvents:'none'}}>
            {Array.from({length: n}).map((_,i) => {
              const a = (i*per - 90 - per/2) * Math.PI/180;
              const x = Math.cos(a)*100, y = Math.sin(a)*100;
              return <line key={i} x1={0} y1={0} x2={x} y2={y} stroke={theme.spokeStroke} strokeWidth="1" />;
            })}
          </svg>
        </div>

        {/* Center cap */}
        <div style={{
          position: 'absolute', left: '50%', top: '50%',
          width: size*0.2, height: size*0.2, transform: 'translate(-50%,-50%)',
          borderRadius: '50%', background: theme.capBg,
          boxShadow: theme.capShadow,
          display:'flex', alignItems:'center', justifyContent:'center',
          fontFamily:'var(--font-display)', fontWeight:900, color:'#fff', fontSize: size*0.06,
          textShadow: '0 1px 0 rgba(0,0,0,.3)',
        }}>SPIN</div>
      </div>

      {/* Top pointer */}
      <div style={{
        position: 'absolute', left: '50%', top: -size*0.02,
        transform: 'translateX(-50%)',
        width: size*0.12, height: size*0.14,
      }}>
        <svg viewBox="0 0 60 70" width="100%" height="100%">
          <path d="M30 68 L8 8 Q30 2 52 8 Z" fill={theme.pointerFill} stroke={theme.pointerStroke} strokeWidth="2.5" strokeLinejoin="round"/>
          <circle cx="30" cy="14" r="5" fill="#fff" opacity=".7"/>
        </svg>
      </div>
    </div>
  );
};

// Confetti burst — simple CSS particles
const Confetti = ({x = 0, y = 0, colors = ['#f5c040','#e8404a','#4a7bc4','#4fd080','#fff']}) => {
  const parts = React.useMemo(() => Array.from({length: 28}).map((_,i) => ({
    angle: (i / 28) * 360,
    dist: 80 + Math.random() * 100,
    delay: Math.random() * 0.2,
    color: colors[i % colors.length],
    rot: Math.random() * 720,
    size: 6 + Math.random() * 8,
  })), [x, y]);
  return (
    <div style={{position:'absolute', left: x, top: y, pointerEvents:'none', zIndex: 50}}>
      {parts.map((p,i) => (
        <div key={i} style={{
          position: 'absolute', left: 0, top: 0,
          width: p.size, height: p.size*0.5,
          background: p.color,
          borderRadius: 1,
          animation: `confettiBurst 1200ms ${p.delay}s ease-out forwards`,
          transform: `rotate(${p.angle}deg) translateY(0)`,
          '--d': `${p.dist}px`, '--r': `${p.rot}deg`,
        }}/>
      ))}
      <style>{`
        @keyframes confettiBurst {
          0% { transform: rotate(var(--angle, 0deg)) translateY(0) rotate(0); opacity: 1 }
          100% { transform: translate(calc(cos(var(--a)) * var(--d)), calc(sin(var(--a)) * var(--d))) rotate(var(--r)); opacity: 0 }
        }
      `}</style>
    </div>
  );
};

// ---------- Themes ----------
const THEME_A = { // Classic carnival
  name: 'Classic Carnival',
  bgGradient: 'radial-gradient(ellipse at top, #4a2018 0%, #2a0d08 70%)',
  titleBg: 'linear-gradient(180deg,#e8404a,#a01820)',
  titleAccent: '#ffe878',
  rimGradient: 'conic-gradient(from 0deg, #ffe878, #d88a10, #ffe878, #d88a10, #ffe878, #d88a10, #ffe878, #d88a10, #ffe878)',
  rimShadow: '0 0 0 4px #8a5a0c, 0 12px 32px rgba(0,0,0,.5), inset 0 0 24px rgba(0,0,0,.3)',
  studFill: '#fff7c0', studStroke: '#8a5a0c',
  discBg: '#fff',
  innerRing: '#fff',
  sectorA: '#e8404a', sectorB: '#fff7e0',
  sectorStroke: '#8a5a0c', spokeStroke: 'rgba(138,90,12,.5)',
  labelColor: '#2a0d08', labelShadow: '0 1px 0 rgba(255,255,255,.4)',
  capBg: 'radial-gradient(circle at 35% 30%, #ffe878, #d88a10)',
  capShadow: '0 0 0 3px #8a5a0c, 0 4px 8px rgba(0,0,0,.4), inset 0 -3px 6px rgba(0,0,0,.3)',
  pointerFill: '#ffe878', pointerStroke: '#8a5a0c',
};

const THEME_B = { // Royal / casino
  name: 'Royal Casino',
  bgGradient: 'radial-gradient(ellipse at top, #1a0d22 0%, #0a0510 70%)',
  titleBg: 'linear-gradient(180deg,#1a1a28,#05050a)',
  titleAccent: '#ffe878',
  rimGradient: 'conic-gradient(from 0deg, #fff7c0, #d88a10, #8a5a0c, #d88a10, #fff7c0, #d88a10, #8a5a0c, #d88a10, #fff7c0)',
  rimShadow: '0 0 0 3px #05050a, 0 0 0 6px #8a5a0c, 0 12px 32px rgba(0,0,0,.7), 0 0 40px rgba(255,232,120,.25)',
  studFill: '#ffe878', studStroke: '#2a1a04',
  discBg: '#0f0a14',
  innerRing: '#d88a10',
  sectorA: '#1a1a28', sectorB: '#6a1020',
  sectorStroke: '#d88a10', spokeStroke: 'rgba(216,138,16,.7)',
  labelColor: '#ffe878', labelShadow: '0 1px 0 rgba(0,0,0,.8)',
  capBg: 'radial-gradient(circle at 35% 30%, #ffe878, #8a5a0c)',
  capShadow: '0 0 0 3px #05050a, 0 0 0 5px #d88a10, 0 4px 8px rgba(0,0,0,.6), inset 0 -3px 6px rgba(0,0,0,.5)',
  pointerFill: '#ffe878', pointerStroke: '#8a5a0c',
};

const THEME_C = { // Current brand — orange / peach cartoon
  name: 'Brand Sunny',
  bgGradient: 'radial-gradient(ellipse at top, #1f3256 0%, #0d1a35 70%)',
  titleBg: 'linear-gradient(180deg, var(--brand-orange-300), var(--brand-orange-500))',
  titleAccent: '#fff',
  rimGradient: 'conic-gradient(from 0deg, #ffd85a, #ff8a4a, #ffd85a, #ff8a4a, #ffd85a, #ff8a4a, #ffd85a, #ff8a4a, #ffd85a)',
  rimShadow: '0 0 0 4px #7a3a0c, 0 12px 32px rgba(0,0,0,.5), inset 0 0 24px rgba(255,255,255,.15)',
  studFill: '#fff', studStroke: '#7a3a0c',
  discBg: '#fff',
  innerRing: '#fff',
  sectorFill: (i) => {
    const palette = ['#ff8a4a', '#7fb3e8', '#4fd080', '#ffd85a', '#ff8a4a', '#e88c7f', '#4fd080', '#ffd85a'];
    return palette[i % palette.length];
  },
  sectorStroke: '#fff', spokeStroke: 'rgba(255,255,255,.8)',
  labelColor: '#fff', labelShadow: '0 2px 0 rgba(0,0,0,.35)',
  capBg: 'radial-gradient(circle at 35% 30%, #ffe878, #e88030)',
  capShadow: '0 0 0 4px #fff, 0 0 0 6px #7a3a0c, 0 4px 8px rgba(0,0,0,.4), inset 0 -3px 6px rgba(0,0,0,.3)',
  pointerFill: '#fff', pointerStroke: '#7a3a0c',
};

const THEMES = { A: THEME_A, B: THEME_B, C: THEME_C };

// ---------- Main component ----------
const DailyRoulette = ({variant = 'A', winningFlow = 'highlight', onClose, onSpin}) => {
  const theme = THEMES[variant] || THEME_A;
  const FREE_LIMIT = 3;

  const [freeLeft, setFreeLeft] = React.useState(FREE_LIMIT);
  const [angle, setAngle] = React.useState(0);
  const [spinning, setSpinning] = React.useState(false);
  const [landed, setLanded] = React.useState(null);
  const [wonReward, setWonReward] = React.useState(null);
  const [showWinPopup, setShowWinPopup] = React.useState(false);
  const [showToast, setShowToast] = React.useState(null);

  // UTC midnight countdown
  const [countdown, setCountdown] = React.useState('');
  React.useEffect(() => {
    const tick = () => {
      const now = new Date();
      const utcNow = now.getTime() + now.getTimezoneOffset() * 60000;
      const utcDate = new Date(utcNow);
      const next = Date.UTC(utcDate.getUTCFullYear(), utcDate.getUTCMonth(), utcDate.getUTCDate() + 1, 0, 0, 0);
      const diff = Math.max(0, next - utcNow);
      const h = String(Math.floor(diff / 3600000)).padStart(2, '0');
      const m = String(Math.floor((diff % 3600000) / 60000)).padStart(2, '0');
      const s = String(Math.floor((diff % 60000) / 1000)).padStart(2, '0');
      setCountdown(`${h}:${m}:${s}`);
    };
    tick();
    const id = setInterval(tick, 1000);
    return () => clearInterval(id);
  }, []);

  const doSpin = () => {
    if (spinning) return;
    if (freeLeft <= 0) return;
    const target = Math.floor(Math.random() * ROULETTE_REWARDS.length);
    const per = 360 / ROULETTE_REWARDS.length;
    const rotations = 5 + Math.floor(Math.random() * 2);
    // target sector's midpoint at angle target*per. We want that to be at top (0deg).
    const desired = rotations * 360 - target * per;
    setLanded(null);
    setAngle(a => {
      // snap to a nearby equivalent of current angle before adding
      const base = Math.floor(a / 360) * 360;
      return base + desired;
    });
    setSpinning(true);
    setTimeout(() => {
      setLanded(target);
      setSpinning(false);
      const reward = ROULETTE_REWARDS[target];
      setWonReward(reward);
      if (winningFlow === 'popup') {
        setTimeout(() => setShowWinPopup(true), 700);
      } else {
        // toast flow: show '+N Gold' text near wheel
        setTimeout(() => setShowToast(reward), 400);
        setTimeout(() => setShowToast(null), 2000);
      }
      setFreeLeft(n => n - 1);
      onSpin && onSpin(reward);
    }, 4300);
  };

  const adForSpin = () => {
    // simulate granting +1 free spin, then allow spin
    setFreeLeft(n => n + 1);
  };

  const titleText = {A: 'Daily Roulette', B: 'Fortune Wheel', C: 'Daily Spin!'}[variant];
  const subtitleText = {
    A: freeLeft > 0 ? `Free spins: ${freeLeft}/${FREE_LIMIT}` : 'Come back tomorrow — or watch an ad',
    B: freeLeft > 0 ? `${freeLeft} of ${FREE_LIMIT} spins remaining today` : 'Next free spin in',
    C: freeLeft > 0 ? `${freeLeft} free spins left today!` : 'Next free spin',
  }[variant];

  return (
    <div style={{
      position: 'absolute', inset: 0, zIndex: 200,
      background: theme.bgGradient,
      animation: 'fadeIn var(--dur-base) var(--ease-out-soft)',
      fontFamily: 'var(--font-ui)',
    }}>
      {/* Close button */}
      <button onClick={onClose} style={{
        position: 'absolute', top: 18, right: 18, zIndex: 5,
        width: 44, height: 44, border: 0, borderRadius: 999,
        background: '#fff', boxShadow: 'var(--shadow-stamp-md)',
        cursor: 'pointer', padding: 0, display:'flex', alignItems:'center', justifyContent:'center',
      }}>
        <Icon name="close" size={20} />
      </button>

      {/* Sparkle backdrop for B */}
      {variant === 'B' && (
        <svg viewBox="0 0 1280 720" style={{position:'absolute', inset:0, width:'100%', height:'100%', opacity:.4, pointerEvents:'none'}}>
          {Array.from({length: 50}).map((_,i) => (
            <circle key={i} cx={Math.random()*1280} cy={Math.random()*720} r={Math.random()*1.5+0.5}
              fill="#ffe878">
              <animate attributeName="opacity" values="0;1;0" dur={`${2+Math.random()*3}s`} repeatCount="indefinite" begin={`${Math.random()*3}s`}/>
            </circle>
          ))}
        </svg>
      )}

      {/* Title banner */}
      <div style={{position:'absolute', top: 24, left: '50%', transform: 'translateX(-50%)', zIndex: 3, textAlign:'center'}}>
        <div style={{
          fontFamily: 'var(--font-display)', fontWeight: 900,
          fontSize: 38, color: theme.titleAccent,
          textShadow: '0 3px 0 rgba(0,0,0,.5), 0 0 24px rgba(255,232,120,.4)',
          letterSpacing: '.02em', lineHeight: 1,
        }}>{titleText}</div>
        <div style={{
          marginTop: 6, display:'inline-block',
          padding:'5px 16px', borderRadius: 999,
          background: 'rgba(0,0,0,.5)', color: '#fff',
          fontSize: 13, fontWeight: 600, letterSpacing: '.04em',
        }}>{subtitleText}</div>
      </div>

      {/* Wheel stage */}
      <div style={{
        position:'absolute', top: '50%', left: '50%',
        transform: 'translate(-50%, -50%) translateY(-10px)',
      }}>
        <Wheel size={330} angle={angle} theme={theme}
          spinning={spinning} landed={landed} winningFlow={winningFlow} />
        {/* Toast flow */}
        {showToast && winningFlow !== 'popup' && (
          <div style={{
            position:'absolute', top: -36, left:'50%', transform:'translateX(-50%)',
            padding:'10px 22px', borderRadius:999,
            background:'linear-gradient(180deg, #ffe878, #d88a10)',
            color:'#2a0d08', fontFamily:'var(--font-display)', fontWeight:900, fontSize:22,
            boxShadow:'var(--shadow-stamp-lg)', whiteSpace:'nowrap',
            animation:'rouletteToast 1.8s ease-out forwards',
          }}>
            + {rewardLabel(showToast)} 🎉
          </div>
        )}
      </div>

      {/* Bottom CTA area */}
      <div style={{position:'absolute', left: 0, right: 0, bottom: 52, display:'flex',
        justifyContent:'center', alignItems:'center', gap: 14, zIndex: 4}}>
        {freeLeft > 0 ? (
          <Button variant="primary" size="lg" onClick={doSpin}
            style={{minWidth: 260, fontSize: 28,
              background: 'linear-gradient(180deg, #ffd85a, #e88030)',
              opacity: spinning ? .6 : 1,
              pointerEvents: spinning ? 'none' : 'auto',
            }}>
            {spinning ? 'Spinning…' : `Spin (${freeLeft}/${FREE_LIMIT})`}
          </Button>
        ) : (
          <div style={{display:'flex', gap: 16, alignItems:'center'}}>
            <button onClick={adForSpin} style={{
              border: 0, cursor: 'pointer',
              background: 'linear-gradient(180deg, #ffd85a, #e88030)',
              padding: '10px 18px 10px 14px', borderRadius: 'var(--r-lg)',
              boxShadow: 'var(--shadow-stamp-md)',
              display:'flex', alignItems:'center', gap: 10,
            }}>
              <Icon name="adPlay" size={44} />
              <div style={{
                fontFamily: 'var(--font-display)', fontWeight: 900, fontSize: 22,
                color:'#fff', textShadow:'0 1px 0 rgba(0,0,0,.3)',
              }}>+1 Spin</div>
            </button>
            <div style={{
              padding:'10px 22px', borderRadius: 'var(--r-lg)',
              background:'rgba(0,0,0,.55)',
              color:'#fff', textAlign:'center',
            }}>
              <div style={{fontSize: 11, letterSpacing:'.1em', opacity:.7, marginBottom:2}}>NEXT FREE SPIN IN</div>
              <div style={{fontFamily:'var(--font-display)', fontWeight: 900, fontSize: 22,
                fontVariantNumeric:'tabular-nums', color: theme.titleAccent}}>{countdown}</div>
            </div>
          </div>
        )}
      </div>

      {/* Winning popup flow */}
      {showWinPopup && wonReward && (
        <div style={{position:'absolute', inset:0, background:'rgba(0,0,0,.6)',
          display:'flex', alignItems:'center', justifyContent:'center', zIndex: 20,
          animation:'fadeIn var(--dur-base) var(--ease-out-soft)',
        }}>
          <div style={{
            background:'var(--paper-50)', borderRadius:'var(--r-2xl)',
            padding:'48px 40px 28px', minWidth: 340, textAlign:'center',
            boxShadow:'var(--shadow-drop-lg), var(--shadow-stamp-lg)', position:'relative',
            animation:'popIn var(--dur-base) var(--ease-out-back)',
          }}>
            <div style={{
              position:'absolute', top:-22, left:'50%', transform:'translateX(-50%)',
              background: 'linear-gradient(180deg, #ffd85a, #e88030)',
              color:'#fff', fontFamily:'var(--font-display)', fontWeight:900, fontSize: 22,
              padding:'10px 32px', borderRadius:'var(--r-lg)',
              boxShadow:'var(--shadow-stamp-md)', textShadow:'0 1px 0 rgba(0,0,0,.25)',
            }}>You Won!</div>
            <div style={{margin: '4px auto 14px', width: 128, height: 128,
              display:'flex', alignItems:'center', justifyContent:'center',
              background:'radial-gradient(circle, rgba(255,232,120,.6), transparent 70%)',
              animation: 'pulse 1.2s ease-in-out infinite',
            }}>
              <Icon name={REWARD_ICON[wonReward.type]} size={100} />
            </div>
            <div style={{fontFamily:'var(--font-display)', fontWeight:900, fontSize: 30,
              color:'var(--ink-900)', letterSpacing:'.01em'}}>
              {rewardLabel(wonReward)}
            </div>
            <div style={{fontSize: 13, color:'var(--ink-500)', marginTop:4, marginBottom: 18}}>
              Added to your inventory
            </div>
            <Button variant="primary" size="lg" onClick={() => setShowWinPopup(false)} style={{minWidth: 200}}>
              Collect
            </Button>
            <Confetti x={0} y={0}/>
          </div>
        </div>
      )}

      <style>{`
        @keyframes rouletteToast {
          0% { opacity: 0; transform: translate(-50%, 10px) scale(.8); }
          15% { opacity: 1; transform: translate(-50%, 0) scale(1.08); }
          30% { transform: translate(-50%, 0) scale(1); }
          80% { opacity: 1; transform: translate(-50%, -8px); }
          100% { opacity: 0; transform: translate(-50%, -40px); }
        }
      `}</style>
    </div>
  );
};

window.DailyRoulette = DailyRoulette;
