// IngameScreen — Reference-matched single layout.
// Layout map:
//  • Top-left: round Settings + Gold pill
//  • Top-right: STREAK BONUS wood panel (5 dots + next reward card peeks)
//  • Bottom-left: Cat mascot + treasure chest (touch → reward popup)
//  • Center: Fan-spread cards (5 above + 5 below, slight overlap)
//  • Bottom-center: Stock pile + Waste card
//  • Bottom-right: Wild booster gold panel + count badge
//  • Undo: small floating button next to the boosters

const STREAK_SLOTS = 5;

// What you'll get when you hit each streak step. Always +1 then Wild for now.
const STREAK_REWARDS = [
  {type: 'plus1', amount: 1},
  {type: 'wild', amount: 1},
  {type: 'gold', amount: 200},
  {type: 'plus1', amount: 1},
  {type: 'wild', amount: 1},
];

// Field — 5 face-up "front" cards on top, 5 piles below where each pile shows a face-down card slightly behind a face-up card peek.
// We model it as 10 logical positions in two rows. Top row is fully face up; bottom row each shows facedown layered.
const buildField = () => {
  const top = [
    {n: 5,  suit: 'red',   col: 0, row: 0},
    {n: 3,  suit: 'black', col: 1, row: 0},
    {n: 6,  suit: 'black', col: 2, row: 0},
    {n: 7,  suit: 'black', col: 3, row: 0},
    {n: 11, suit: 'black', col: 4, row: 0},
  ];
  const bottom = [
    {n: 8,  suit: 'black', col: 0, row: 1, hasPile: true},
    {n: null, hidden: true, col: 1, row: 1, hasPile: true},
    {n: 12, suit: 'black', col: 2, row: 1, hasPile: true},
    {n: null, hidden: true, col: 3, row: 1, hasPile: true},
    {n: 2,  suit: 'red',   col: 4, row: 1, hasPile: true},
  ];
  // Top covers bottom horizontally — index by id
  return [...top, ...bottom].map((c, i) => ({...c, id: 't' + i}));
};

// ----------- Reusable mini parts ------------

const StreakBonusPanel = ({streak, onTouch}) => {
  const next = STREAK_REWARDS[streak] || STREAK_REWARDS[0];
  const after = STREAK_REWARDS[(streak + 1) % STREAK_REWARDS.length];
  return (
    <div onClick={onTouch} style={{
      display: 'flex', alignItems: 'center', cursor: 'pointer', userSelect: 'none',
      filter: 'drop-shadow(0 4px 6px rgba(0,0,0,.4))',
    }}>
      {/* Wood panel with title + dots */}
      <div style={{
        background: 'linear-gradient(180deg, #fff5e0 0%, #f3d8a0 100%)',
        borderRadius: '14px 0 0 14px',
        padding: '10px 22px 12px 22px',
        border: '2.5px solid #7a4a0c',
        borderRight: 'none',
        boxShadow: 'inset 0 -3px 0 rgba(122,74,12,.25), inset 0 1px 0 rgba(255,255,255,.7)',
        textAlign: 'center', minWidth: 160,
      }}>
        <div style={{
          fontFamily: 'var(--font-display)', fontWeight: 900, fontSize: 14,
          color: '#7a4a0c', letterSpacing: '.14em', marginBottom: 6,
          textShadow: '0 1px 0 rgba(255,255,255,.5)',
        }}>STREAK BONUS</div>
        <div style={{display: 'flex', gap: 6, justifyContent: 'center'}}>
          {Array.from({length: STREAK_SLOTS}).map((_, i) => {
            const filled = i < streak;
            return (
              <div key={i} style={{
                width: 14, height: 14, borderRadius: '50%',
                background: filled
                  ? 'radial-gradient(circle at 35% 30%, #ffe878, #c98010 70%)'
                  : 'radial-gradient(circle at 35% 30%, #5a3a18, #2a1a08 70%)',
                boxShadow: filled
                  ? '0 0 6px rgba(255,225,90,.9), inset 0 0 1px rgba(255,255,255,.6)'
                  : 'inset 0 1px 1px rgba(0,0,0,.5)',
                border: '1.2px solid #7a4a0c',
              }}/>
            );
          })}
        </div>
      </div>
      {/* Next-reward card peeks */}
      <div style={{
        display: 'flex', alignItems: 'flex-end', gap: 3,
        background: 'linear-gradient(180deg, #4a8eda, #2a6abf)',
        borderRadius: '0 14px 14px 0',
        padding: '8px 12px 8px 8px',
        border: '2.5px solid #7a4a0c',
        borderLeft: 'none',
        boxShadow: 'inset 0 -3px 0 rgba(0,0,0,.18)',
      }}>
        <RewardCardPeek type={next.type} primary />
        <RewardCardPeek type={after.type} />
      </div>
    </div>
  );
};

const RewardCardPeek = ({type, primary}) => {
  const w = primary ? 36 : 30;
  const h = primary ? 48 : 40;
  return (
    <div style={{
      width: w, height: h, background: '#fff',
      borderRadius: 4, border: '1.5px solid #2a4a8e',
      boxShadow: '0 2px 3px rgba(0,0,0,.35)',
      display: 'flex', alignItems: 'center', justifyContent: 'center',
      flexShrink: 0,
    }}>
      {type === 'plus1' && (
        <div style={{
          color: '#3fb060', fontFamily: 'var(--font-display)', fontWeight: 900,
          fontSize: primary ? 17 : 13, lineHeight: 1,
        }}>+1</div>
      )}
      {type === 'wild' && (
        <div style={{
          color: '#a040d8', fontFamily: 'var(--font-display)', fontWeight: 900,
          fontSize: primary ? 11 : 9, lineHeight: 1, textAlign: 'center',
          letterSpacing: '.05em',
        }}>WILD</div>
      )}
      {type === 'gold' && (
        <div style={{transform: `scale(${primary ? 0.7 : 0.6})`}}>
          <Icon name="coin" size={32}/>
        </div>
      )}
    </div>
  );
};

// Round settings button — blue capsule
const SettingsButton = ({onClick}) => (
  <button onClick={onClick} style={{
    width: 50, height: 50, borderRadius: '50%', border: 0, padding: 0,
    cursor: 'pointer',
    background: 'linear-gradient(180deg, #5aa0e8, #2a6abf)',
    boxShadow: 'inset 0 -3px 0 rgba(0,0,0,.25), inset 0 1px 0 rgba(255,255,255,.4), 0 3px 5px rgba(0,0,0,.4)',
    border: '2.5px solid #fff',
    display: 'flex', alignItems: 'center', justifyContent: 'center',
  }}>
    {/* Simple gear */}
    <svg viewBox="0 0 24 24" width="26" height="26" fill="#fff">
      <path d="M12 8a4 4 0 100 8 4 4 0 000-8zm0 6a2 2 0 110-4 2 2 0 010 4zM21 12.4l-2-.5a7 7 0 00-.5-1.2l1-1.7-2-2-1.7 1a7 7 0 00-1.2-.5l-.5-2h-3l-.5 2a7 7 0 00-1.2.5l-1.7-1-2 2 1 1.7a7 7 0 00-.5 1.2l-2 .5v3l2 .5c.13.42.3.82.5 1.2l-1 1.7 2 2 1.7-1c.38.2.78.37 1.2.5l.5 2h3l.5-2c.42-.13.82-.3 1.2-.5l1.7 1 2-2-1-1.7c.2-.38.37-.78.5-1.2l2-.5v-3z"/>
    </svg>
  </button>
);

// Cat + chest (bottom-left) — combined illustration. Press-hold shows contents bubble.
const MascotChest = ({contents, showBubble, onPressStart, onPressEnd}) => {
  const total = (contents.star || 0) + (contents.gold || 0) + (contents.wild || 0) + (contents.plus1 || 0);
  return (
    <div
      onMouseDown={onPressStart} onMouseUp={onPressEnd} onMouseLeave={onPressEnd}
      onTouchStart={onPressStart} onTouchEnd={onPressEnd}
      style={{
      position: 'relative', width: 280, height: 230, cursor: 'pointer',
      filter: 'drop-shadow(0 6px 8px rgba(0,0,0,.4))', userSelect: 'none',
    }}>
      {showBubble && (
        <div style={{
          position: 'absolute', bottom: 126, left: 118, zIndex: 5,
          background: '#fff', borderRadius: 14, padding: '10px 14px',
          boxShadow: '0 4px 12px rgba(0,0,0,.4)',
          display: 'flex', gap: 12, alignItems: 'center',
          animation: 'popIn .2s var(--ease-out-back)',
        }}>
          {[
            {key:'star', icon:'streakStar'},
            {key:'gold', icon:'coin'},
            {key:'wild', icon:'wild'},
            {key:'plus1', icon:'plusCard'},
          ].map(r => (
            <div key={r.key} style={{display:'flex', flexDirection:'column', alignItems:'center', gap:2, opacity: (contents[r.key]||0) > 0 ? 1 : .4}}>
              <Icon name={r.icon} size={28}/>
              <div style={{fontFamily:'var(--font-display)', fontWeight:900, fontSize:13, color:'var(--ink-900)'}}>{contents[r.key] || 0}</div>
            </div>
          ))}
          <div style={{position:'absolute', bottom:-8, left:28, width:0, height:0,
            borderLeft:'9px solid transparent', borderRight:'9px solid transparent',
            borderTop:'10px solid #fff'}}/>
        </div>
      )}
      {/* Plant pot behind */}
      <svg viewBox="0 0 280 230" width="280" height="230" style={{position:'absolute', inset:0}}>
        <defs>
          <linearGradient id="potGrad" x1="0" y1="0" x2="0" y2="1">
            <stop offset="0" stopColor="#5aa030"/><stop offset="1" stopColor="#2a6018"/>
          </linearGradient>
          <linearGradient id="leafGrad" x1="0" y1="0" x2="0" y2="1">
            <stop offset="0" stopColor="#7ad048"/><stop offset="1" stopColor="#3a8020"/>
          </linearGradient>
          <linearGradient id="potBody" x1="0" y1="0" x2="0" y2="1">
            <stop offset="0" stopColor="#a86028"/><stop offset="1" stopColor="#6a3a08"/>
          </linearGradient>
        </defs>
        {/* Banana leaves behind */}
        <path d="M50 170 Q25 100 38 38 Q53 64 64 130 Z" fill="url(#leafGrad)" stroke="#2a4a18" strokeWidth="2"/>
        <path d="M38 40 Q57 64 64 130" stroke="#2a4a18" strokeWidth="2" fill="none"/>
        <path d="M70 170 Q50 90 76 26 Q88 76 90 142 Z" fill="url(#leafGrad)" stroke="#2a4a18" strokeWidth="2"/>
        <path d="M76 28 Q83 76 90 142" stroke="#2a4a18" strokeWidth="2" fill="none"/>
        <path d="M90 165 Q76 90 108 38 Q112 90 102 148 Z" fill="url(#leafGrad)" stroke="#2a4a18" strokeWidth="2"/>
        {/* Pot at bottom-left of frame */}
        <path d="M18 168 L100 168 L92 222 L26 222 Z" fill="url(#potBody)" stroke="#3a1a04" strokeWidth="3" strokeLinejoin="round"/>
        <ellipse cx="59" cy="168" rx="41" ry="7" fill="#7a4a08" stroke="#3a1a04" strokeWidth="2.5"/>
      </svg>
      {/* Cat mascot in center */}
      <div style={{position: 'absolute', left: 50, top: 60, width: 150, height: 150}}>
        <Icon name="catMascot" size={150}/>
      </div>
      {/* Chest in front */}
      <div style={{position: 'absolute', right: 0, bottom: 6, width: 145, height: 120}}>
        <Icon name="treasureChest" size={145}/>
        {total > 0 && (
          <div style={{
            position: 'absolute', top: -2, right: 6,
            background: '#e8404a', color: '#fff', fontSize: 13, fontWeight: 900,
            padding: '2px 8px', borderRadius: 999, border: '2px solid #fff',
            fontFamily: 'var(--font-display)', minWidth: 24, textAlign: 'center',
            boxShadow: '0 2px 4px rgba(0,0,0,.4)',
          }}>{total}</div>
        )}
      </div>
    </div>
  );
};

// Wild booster gold panel — bottom right
const WildBooster = ({count, price, onClick}) => {
  const showPrice = count === 0;
  return (
    <div onClick={onClick} style={{
      position: 'relative', width: 76, height: 100, cursor: 'pointer',
      filter: 'drop-shadow(0 5px 6px rgba(0,0,0,.45))',
    }}>
      {/* Outer gold border */}
      <div style={{
        position: 'absolute', inset: 0, borderRadius: 12,
        background: 'linear-gradient(180deg, #ffe878, #c98010)',
        padding: 3, boxShadow: 'inset 0 -2px 0 rgba(122,74,12,.4), inset 0 1px 0 rgba(255,255,255,.6)',
      }}>
        {/* Inner card */}
        <div style={{
          height: '100%', borderRadius: 9,
          background: 'linear-gradient(180deg, #fff7d0, #ffd870 60%, #d89028)',
          display: 'flex', flexDirection: 'column', alignItems: 'center', justifyContent: 'center',
          gap: 2, padding: '6px 4px',
          boxShadow: 'inset 0 1px 1px rgba(255,255,255,.6)',
          position: 'relative',
        }}>
          {/* Wild glyph — magic wand / sparkle */}
          <svg viewBox="0 0 64 64" width="38" height="38">
            <defs>
              <linearGradient id="wandStar" x1="0" y1="0" x2="0" y2="1">
                <stop offset="0" stopColor="#fff"/><stop offset="1" stopColor="#ffe878"/>
              </linearGradient>
            </defs>
            {/* Wand stick */}
            <rect x="36" y="34" width="6" height="24" rx="2" fill="#7a4a0c" transform="rotate(20 39 46)"/>
            <rect x="36" y="34" width="6" height="6" rx="1" fill="#fff" transform="rotate(20 39 46)"/>
            {/* Big star */}
            <path d="M22 8 L26 18 L36 20 L29 27 L31 38 L22 33 L13 38 L15 27 L8 20 L18 18 Z"
              fill="url(#wandStar)" stroke="#7a4a0c" strokeWidth="1.5" strokeLinejoin="round"/>
          </svg>
          <div style={{
            fontFamily: 'var(--font-display)', fontWeight: 900, fontSize: 14,
            color: '#7a4a0c', letterSpacing: '.08em',
            textShadow: '0 1px 0 rgba(255,255,255,.6)',
          }}>WILD</div>
        </div>
      </div>
      {/* Count badge OR price */}
      {showPrice ? (
        <div style={{
          position: 'absolute', bottom: -10, left: '50%', transform: 'translateX(-50%)',
          display: 'flex', alignItems: 'center', gap: 3,
          background: 'linear-gradient(180deg, #fff, #f3e3c8)',
          padding: '3px 9px 3px 6px', borderRadius: 999,
          border: '1.5px solid #7a4a0c',
          fontFamily: 'var(--font-display)', fontWeight: 900, fontSize: 11, color: '#7a4a0c',
          whiteSpace: 'nowrap', boxShadow: '0 2px 4px rgba(0,0,0,.4)',
        }}>
          <Icon name="coin" size={14}/>
          <span>{price}</span>
        </div>
      ) : (
        <div style={{
          position: 'absolute', top: -6, right: -6,
          width: 24, height: 24, borderRadius: 999,
          background: '#e8404a', color: '#fff', fontSize: 12, fontWeight: 900,
          display: 'flex', alignItems: 'center', justifyContent: 'center',
          border: '2px solid #fff', fontFamily: 'var(--font-display)',
          boxShadow: '0 2px 4px rgba(0,0,0,.4)',
        }}>{count}</div>
      )}
    </div>
  );
};

// Compact undo button — small and floating
const UndoBooster = ({count, price, onClick}) => {
  const showPrice = count === 0;
  return (
    <div onClick={onClick} style={{
      position: 'relative', width: 54, height: 54, cursor: 'pointer',
      filter: 'drop-shadow(0 4px 5px rgba(0,0,0,.4))',
    }}>
      <div style={{
        width: '100%', height: '100%', borderRadius: 12,
        background: 'linear-gradient(180deg, #fff, #e8d0a8)',
        border: '2px solid #7a4a0c',
        boxShadow: 'inset 0 -2px 0 rgba(122,74,12,.25)',
        display: 'flex', alignItems: 'center', justifyContent: 'center',
      }}>
        <Icon name="undo" size={36}/>
      </div>
      {showPrice ? (
        <div style={{
          position: 'absolute', bottom: -8, left: '50%', transform: 'translateX(-50%)',
          display: 'flex', alignItems: 'center', gap: 2,
          background: 'linear-gradient(180deg, #fff, #f3e3c8)',
          padding: '2px 7px 2px 5px', borderRadius: 999,
          border: '1.2px solid #7a4a0c',
          fontFamily: 'var(--font-display)', fontWeight: 900, fontSize: 10, color: '#7a4a0c',
          whiteSpace: 'nowrap', boxShadow: '0 2px 3px rgba(0,0,0,.4)',
        }}>
          <Icon name="coin" size={12}/>
          <span>{price}</span>
        </div>
      ) : (
        <div style={{
          position: 'absolute', top: -5, right: -5,
          width: 20, height: 20, borderRadius: 999,
          background: '#e8404a', color: '#fff', fontSize: 11, fontWeight: 900,
          display: 'flex', alignItems: 'center', justifyContent: 'center',
          border: '2px solid #fff', fontFamily: 'var(--font-display)',
          boxShadow: '0 1px 3px rgba(0,0,0,.4)',
        }}>{count}</div>
      )}
    </div>
  );
};

// Streak tooltip
const StreakTooltip = ({visible}) => visible && (
  <div style={{
    position: 'absolute', right: 0, top: '100%', marginTop: 8,
    background: 'rgba(0,0,0,.88)', color: '#fff',
    padding: '10px 16px', borderRadius: 10,
    fontSize: 13, fontWeight: 600, lineHeight: 1.3,
    whiteSpace: 'nowrap', pointerEvents: 'none',
    fontFamily: 'var(--font-ui)',
    boxShadow: '0 4px 12px rgba(0,0,0,.4)',
    zIndex: 20,
  }}>
    연속으로 카드를 제거할 수록 더 큰 보상!
    <div style={{
      position: 'absolute', top: -7, right: 24,
      width: 0, height: 0, borderLeft: '7px solid transparent', borderRight: '7px solid transparent',
      borderBottom: '7px solid rgba(0,0,0,.88)',
    }}/>
  </div>
);

// ----------- Popups (re-used from previous version) ------------

const RewardChestPopup = ({contents, onClose}) => (
  <div style={{
    position: 'absolute', inset: 0, background: 'rgba(0,0,0,.72)', zIndex: 100,
    display: 'flex', alignItems: 'center', justifyContent: 'center',
    animation: 'fadeIn var(--dur-base) var(--ease-out-soft)',
  }}>
    <div style={{
      background: 'var(--paper-50)', borderRadius: 'var(--r-2xl)',
      padding: '52px 28px 22px', minWidth: 380, textAlign: 'center', position: 'relative',
      boxShadow: 'var(--shadow-drop-lg), var(--shadow-stamp-lg)',
      animation: 'popIn var(--dur-base) var(--ease-out-back)',
    }}>
      <div style={{
        position: 'absolute', top: -32, left: '50%', transform: 'translateX(-50%)',
      }}>
        <Icon name="treasureChest" size={72}/>
      </div>
      <button onClick={onClose} style={{
        position: 'absolute', top: -10, right: -10, width: 34, height: 34,
        border: 0, borderRadius: 999, background: '#fff', boxShadow: 'var(--shadow-stamp-md)',
        cursor: 'pointer', padding: 0, display: 'flex', alignItems: 'center', justifyContent: 'center',
      }}><Icon name="close" size={16}/></button>
      <div style={{
        fontFamily: 'var(--font-display)', fontWeight: 900, fontSize: 22,
        color: 'var(--ink-900)', marginBottom: 4, marginTop: 6,
      }}>레벨 보상 상자</div>
      <div style={{fontSize: 12, color: 'var(--ink-500)', marginBottom: 14}}>
        레벨 클리어 시 모두 획득해요
      </div>
      <div style={{display: 'grid', gridTemplateColumns: '1fr 1fr', gap: 10}}>
        {[
          {key: 'star',  icon: 'streakStar', label: 'Streak Stars'},
          {key: 'gold',  icon: 'coin',       label: 'Gold'},
          {key: 'wild',  icon: 'wild',       label: 'Wild Cards'},
          {key: 'plus1', icon: 'plusCard',   label: '+1 Cards'},
        ].map(row => (
          <div key={row.key} style={{
            display: 'flex', alignItems: 'center', gap: 10,
            background: '#fff', padding: '10px 14px', borderRadius: 'var(--r-md)',
            boxShadow: 'var(--shadow-stamp-sm)',
            opacity: (contents[row.key] || 0) > 0 ? 1 : 0.45,
          }}>
            <Icon name={row.icon} size={34}/>
            <div style={{flex: 1, textAlign: 'left'}}>
              <div style={{fontSize: 11, color: 'var(--ink-500)'}}>{row.label}</div>
              <div style={{fontFamily: 'var(--font-display)', fontWeight: 900, fontSize: 18, color: 'var(--ink-900)'}}>
                {contents[row.key] || 0}
              </div>
            </div>
          </div>
        ))}
      </div>
    </div>
  </div>
);

const NoGoldAdPopup = ({onWatchAd, onClose, needed}) => (
  <div style={{
    position: 'absolute', inset: 0, background: 'rgba(0,0,0,.68)', zIndex: 100,
    display: 'flex', alignItems: 'center', justifyContent: 'center',
    animation: 'fadeIn var(--dur-base) var(--ease-out-soft)', backdropFilter: 'blur(3px)',
  }}>
    <div style={{
      background: 'var(--paper-50)', borderRadius: 'var(--r-2xl)',
      padding: '44px 32px 24px', minWidth: 360, textAlign: 'center', position: 'relative',
      boxShadow: 'var(--shadow-drop-lg), var(--shadow-stamp-lg)',
      animation: 'popIn var(--dur-base) var(--ease-out-back)',
    }}>
      <div style={{
        position: 'absolute', top: -22, left: '50%', transform: 'translateX(-50%)',
        background: 'linear-gradient(180deg, #ff8a4a, #e8541c)',
        color: '#fff', fontFamily: 'var(--font-display)', fontWeight: 900, fontSize: 20,
        padding: '10px 28px', borderRadius: 'var(--r-lg)',
        boxShadow: 'var(--shadow-stamp-md)', textShadow: '0 1px 0 rgba(0,0,0,.3)',
      }}>골드가 부족해요</div>
      <div style={{margin: '10px auto 14px', display: 'flex', justifyContent: 'center', gap: 14, alignItems: 'center'}}>
        <Icon name="coin" size={56}/>
        <div style={{fontFamily: 'var(--font-display)', fontWeight: 900, fontSize: 30, color: 'var(--ink-900)'}}>
          +{needed}
        </div>
      </div>
      <div style={{fontSize: 14, color: 'var(--ink-500)', marginBottom: 18}}>
        광고를 보고 골드를 무료로 받아보세요!
      </div>
      <div style={{display: 'flex', gap: 10, justifyContent: 'center'}}>
        <Button variant="ghost" onClick={onClose} style={{background: 'rgba(0,0,0,.06)'}}>닫기</Button>
        <Button variant="primary" onClick={onWatchAd}>
          <span style={{display: 'inline-flex', alignItems: 'center', gap: 6}}>
            <Icon name="adPlay" size={22}/>
            광고 보기
          </span>
        </Button>
      </div>
    </div>
  </div>
);

const GiveUpPopup = ({onConfirm, onCancel}) => (
  <div style={{
    position: 'absolute', inset: 0, background: 'rgba(0,0,0,.72)', zIndex: 100,
    display: 'flex', alignItems: 'center', justifyContent: 'center',
    animation: 'fadeIn var(--dur-base) var(--ease-out-soft)',
  }}>
    <div style={{
      background: 'var(--paper-50)', borderRadius: 'var(--r-2xl)',
      padding: '44px 28px 22px', minWidth: 340, textAlign: 'center', position: 'relative',
      boxShadow: 'var(--shadow-drop-lg), var(--shadow-stamp-lg)',
      animation: 'popIn var(--dur-base) var(--ease-out-back)',
    }}>
      <div style={{
        position: 'absolute', top: -22, left: '50%', transform: 'translateX(-50%)',
        background: 'linear-gradient(180deg, #e8404a, #a01820)',
        color: '#fff', fontFamily: 'var(--font-display)', fontWeight: 900, fontSize: 18,
        padding: '10px 24px', borderRadius: 'var(--r-lg)',
        boxShadow: 'var(--shadow-stamp-md)', textShadow: '0 1px 0 rgba(0,0,0,.3)',
      }}>포기할까요?</div>
      <div style={{margin: '6px auto 12px'}}><Icon name="giveUp" size={64}/></div>
      <div style={{fontSize: 14, color: 'var(--ink-700)', marginBottom: 4, lineHeight: 1.4}}>
        정말 이 레벨을 포기하시겠어요?
      </div>
      <div style={{fontSize: 12, color: 'var(--ink-500)', marginBottom: 18}}>
        상자에 모아둔 보상은 모두 사라져요.
      </div>
      <div style={{display: 'flex', gap: 10, justifyContent: 'center'}}>
        <Button variant="ghost" onClick={onCancel} style={{background: 'rgba(0,0,0,.06)'}}>계속하기</Button>
        <Button variant="primary" onClick={onConfirm} style={{background: 'linear-gradient(180deg, #e8404a, #a01820)'}}>포기</Button>
      </div>
    </div>
  </div>
);

const IngameSettingsPopup = ({onClose, onHome}) => (
  <div style={{
    position: 'absolute', inset: 0, background: 'rgba(0,0,0,.72)', zIndex: 100,
    display: 'flex', alignItems: 'center', justifyContent: 'center',
    animation: 'fadeIn var(--dur-base) var(--ease-out-soft)',
  }}>
    <div style={{
      background: 'var(--paper-50)', borderRadius: 'var(--r-2xl)',
      padding: '44px 28px 22px', minWidth: 340, textAlign: 'center', position: 'relative',
      boxShadow: 'var(--shadow-drop-lg), var(--shadow-stamp-lg)',
      animation: 'popIn var(--dur-base) var(--ease-out-back)',
    }}>
      <div style={{
        position: 'absolute', top: -22, left: '50%', transform: 'translateX(-50%)',
        background: 'linear-gradient(180deg, var(--brand-blue-300), var(--brand-blue-500))',
        color: '#fff', fontFamily: 'var(--font-display)', fontWeight: 900, fontSize: 20,
        padding: '10px 28px', borderRadius: 'var(--r-lg)',
        boxShadow: 'var(--shadow-stamp-md)',
      }}>설정</div>
      <button onClick={onClose} style={{
        position: 'absolute', top: -10, right: -10, width: 34, height: 34,
        border: 0, borderRadius: 999, background: '#fff', boxShadow: 'var(--shadow-stamp-md)',
        cursor: 'pointer', padding: 0, display: 'flex', alignItems: 'center', justifyContent: 'center',
      }}><Icon name="close" size={16}/></button>
      {[
        {label: '효과음', on: true},
        {label: '음악', on: true},
        {label: '진동', on: false},
        {label: '왼손 모드', on: false},
      ].map(row => (
        <div key={row.label} style={{
          display: 'flex', justifyContent: 'space-between', alignItems: 'center',
          padding: '12px 14px', background: '#fff', borderRadius: 'var(--r-md)',
          boxShadow: 'var(--shadow-stamp-sm)', marginBottom: 8,
          fontFamily: 'var(--font-ui)', fontSize: 14, color: 'var(--ink-900)', fontWeight: 600,
        }}>
          {row.label}
          <div style={{
            width: 44, height: 24, borderRadius: 999,
            background: row.on ? 'var(--brand-green-400)' : '#bbb',
            position: 'relative', transition: 'all .2s',
          }}>
            <div style={{
              position: 'absolute', top: 2, left: row.on ? 22 : 2,
              width: 20, height: 20, borderRadius: '50%',
              background: '#fff', boxShadow: '0 1px 3px rgba(0,0,0,.3)', transition: 'all .2s',
            }}/>
          </div>
        </div>
      ))}
      <div style={{height: 10}}/>
      <Button variant="secondary" size="md" onClick={onHome} style={{width: '100%'}}>로비로 나가기</Button>
    </div>
  </div>
);

// ============= Main IngameScreen =============

const IngameScreen = ({level, gold: initGold, onClear, onHome}) => {
  const [field, setField] = React.useState(buildField);
  const [waste, setWaste] = React.useState({n: 2, suit: 'black'});
  const [stock, setStock] = React.useState(() =>
    Array.from({length: 12}).map((_, i) => ({n: ((i*3)%13)+1, suit: i%2 ? 'red' : 'black'}))
  );
  const [gold, setGold] = React.useState(initGold);
  const [shakeId, setShakeId] = React.useState(null);
  const [removing, setRemoving] = React.useState(null);

  const [streak, setStreak] = React.useState(0);
  const [boxContents, setBoxContents] = React.useState({star: 0, gold: 0, wild: 0, plus1: 0});

  const [wildCount, setWildCount] = React.useState(1);
  const [undoCount, setUndoCount] = React.useState(2);

  const [showStreakTip, setShowStreakTip] = React.useState(false);
  const [showAdPopup, setShowAdPopup] = React.useState(false);
  const [showGiveUp, setShowGiveUp] = React.useState(false);
  const [showSettings, setShowSettings] = React.useState(false);
  const [chestBubble, setChestBubble] = React.useState(false);
  const [adNeeded, setAdNeeded] = React.useState(0);
  const [wildInWaste, setWildInWaste] = React.useState(false);
  // History stack for full-rewind undo: snapshot every move.
  const historyRef = React.useRef([]);
  const snapshot = () => historyRef.current.push({
    field: field.map(c=>({...c})), waste:{...waste}, stock:stock.map(c=>({...c})),
    gold, streak, boxContents:{...boxContents}, wildCount, wildInWaste,
  });

  const UNDO_COST = 250;
  const WILD_COST = 400;

  const canMatch = (a, b) => {
    if (wildInWaste) return true; // wild matches anything
    return Math.abs(a - b) === 1 || Math.abs(a - b) === 12;
  };

  const handleCard = (card) => {
    if (card.gone || card.hidden) return;
    if (!canMatch(card.n, waste.n)) {
      setShakeId(card.id); setTimeout(() => setShakeId(null), 300);
      setStreak(0);
      return;
    }
    snapshot();
    setRemoving(card.id);
    setTimeout(() => {
      setField(f => f.map(c => c.id === card.id ? {...c, gone: true, hidden: c.hasPile} : c));
      setWaste({n: card.n, suit: card.suit});
      setWildInWaste(false);
      setRemoving(null);
      // New rule: fill the meter; when the final slot fills, PAY OUT the current reward and reset to 0,
      // advancing the rotation so the "next" reward moves forward.
      setStreak(s => {
        const next = s + 1;
        if (next >= STREAK_SLOTS) {
          const r = STREAK_REWARDS[0]; // what was shown as "next" during the fill
          if (r) setBoxContents(b => ({...b, [r.type]: (b[r.type] || 0) + r.amount}));
          // Rotate rewards so the old "after" becomes the new "next"
          STREAK_REWARDS.push(STREAK_REWARDS.shift());
          return 0;
        }
        return next;
      });
      const remaining = field.filter(c => !c.gone && c.id !== card.id && !c.hidden);
      if (remaining.length === 0) setTimeout(() => onClear(), 500);
    }, 240);
  };

  const handleDraw = () => {
    if (stock.length === 0) return;
    snapshot();
    setWaste(stock[0]); setStock(s => s.slice(1));
    setWildInWaste(false);
    setStreak(0);
  };

  // Full-rewind undo: pop ALL snapshots back to the initial state.
  // Consumes one undo item, or charges gold, or prompts ad.
  const handleUndo = () => {
    if (historyRef.current.length === 0) return;
    if (undoCount > 0) setUndoCount(c => c - 1);
    else if (gold >= UNDO_COST) setGold(g => g - UNDO_COST);
    else { setAdNeeded(UNDO_COST - gold); setShowAdPopup(true); return; }
    // Rewind to the very first snapshot — spec: revert EVERYTHING back to game start.
    const first = historyRef.current[0];
    historyRef.current = [];
    setField(first.field); setWaste(first.waste); setStock(first.stock);
    setGold(first.gold); setStreak(first.streak); setBoxContents(first.boxContents);
    // Booster items consumed since start are returned as inventory (not gold).
    setWildCount(first.wildCount);
    setWildInWaste(false);
  };
  // Wild matches any card — moves to waste pile and becomes the new match target.
  const handleWild = () => {
    if (wildCount > 0) {
      snapshot();
      setWildCount(c => c - 1);
      setWildInWaste(true);
      // Waste becomes a "wild" — any card in field can be played next.
      setWaste({n: 0, suit: 'wild'});
    }
    else if (gold >= WILD_COST) {
      setGold(g => g - WILD_COST);
      snapshot();
      setWildInWaste(true);
      setWaste({n: 0, suit: 'wild'});
    }
    else { setAdNeeded(WILD_COST - gold); setShowAdPopup(true); }
  };
  const handleExtraDeck = () => {
    setStock(s => [...s, {n: 3, suit: 'red'}, {n: 11, suit: 'black'}, {n: 7, suit: 'red'}, {n: 5, suit: 'black'}, {n: 12, suit: 'red'}]);
  };

  const stockExhausted = stock.length === 0;

  // --- Field layout: fan-spread, top row 5 cards (face-up), bottom row 5 cards (face-down pile + face-up peek)
  const fieldCenterX = 640;
  const fieldTop = 100;
  const cardW = 84;
  const overlapX = 12; // overlap between adjacent cards horizontally
  const stepX = cardW - overlapX;
  const totalRowW = 5 * stepX + overlapX;
  const startX = fieldCenterX - totalRowW / 2;
  const rowGap = 78;

  const visibleField = field.filter(c => !c.gone || c.hasPile);

  return (
    <div style={{position: 'absolute', inset: 0,
      background: 'radial-gradient(ellipse at 50% 30%, #d8a868 0%, #a86838 45%, #6a3a18 100%)',
    }}>
      {/* Subtle wood-grain noise */}
      <div style={{position: 'absolute', inset: 0, opacity: .15, pointerEvents: 'none',
        backgroundImage: 'repeating-linear-gradient(95deg, transparent 0 22px, rgba(60,30,8,.4) 22px 23px, transparent 23px 50px)',
      }}/>

      {/* Top-left: Settings + Gold */}
      <div style={{position: 'absolute', top: 16, left: 18, display: 'flex', alignItems: 'center', gap: 10, zIndex: 5}}>
        <SettingsButton onClick={() => setShowSettings(true)}/>
        <div style={{position: 'relative'}}>
          <CurrencyPill icon="coin" value={gold}/>
          <button onClick={() => alert('Shop (TBD)')} style={{
            position: 'absolute', right: -10, top: '50%', transform: 'translateY(-50%)',
            width: 28, height: 28, borderRadius: '50%', border: '2.5px solid #fff', padding: 0,
            background: 'linear-gradient(180deg, #5aa0e8, #2a6abf)',
            color: '#fff', fontWeight: 900, fontSize: 18, cursor: 'pointer',
            boxShadow: '0 2px 4px rgba(0,0,0,.4)',
            display: 'flex', alignItems: 'center', justifyContent: 'center', lineHeight: 1,
          }}>+</button>
        </div>
      </div>

      {/* Top-right: STREAK BONUS panel */}
      <div style={{position: 'absolute', top: 12, right: 0, zIndex: 5, paddingRight: 8}}>
        <div style={{position: 'relative'}}>
          <StreakBonusPanel streak={streak} onTouch={() => {
            setShowStreakTip(true); setTimeout(() => setShowStreakTip(false), 2200);
          }}/>
          <StreakTooltip visible={showStreakTip}/>
        </div>
      </div>

      {/* Play field — fan spread */}
      <div style={{position: 'absolute', inset: 0}}>
        {visibleField.map(card => {
          const x = startX + card.col * stepX;
          const y = fieldTop + card.row * rowGap;
          const canPlay = !card.gone && !card.hidden && canMatch(card.n, waste.n);
          // For pile slots: render face-down behind a peek of the actual card
          if (card.hasPile && !card.gone) {
            return (
              <div key={card.id} style={{position: 'absolute', left: x, top: y,
                animation: shakeId === card.id ? 'shake .3s' : removing === card.id ? 'cardRemove var(--dur-base) forwards' : 'none',
                width: cardW, height: cardW * 1.4 + 16,
              }}>
                {/* Face-down stack peeking from BEHIND, offset slightly up so only top sliver shows */}
                <div style={{position: 'absolute', left: -4, top: -8}}>
                  <PlayingCard faceDown style={{width: cardW, height: cardW * 1.4}}/>
                </div>
                <div style={{position: 'absolute', left: 4, top: -4}}>
                  <PlayingCard faceDown style={{width: cardW, height: cardW * 1.4}}/>
                </div>
                {/* Front card (face-up if available, otherwise face-down) */}
                <div style={{position: 'absolute', left: 0, top: 0,
                  filter: canPlay ? 'drop-shadow(0 0 10px rgba(255,225,90,.7))' : 'none',
                }}>
                  {card.hidden ? (
                    <PlayingCard faceDown style={{width: cardW, height: cardW * 1.4}}/>
                  ) : (
                    <PlayingCard n={card.n} suit={card.suit}
                      style={{width: cardW, height: cardW * 1.4}}
                      onClick={() => handleCard(card)}/>
                  )}
                </div>
              </div>
            );
          }
          if (card.gone) return null;
          return (
            <div key={card.id} style={{position: 'absolute', left: x, top: y,
              animation: shakeId === card.id ? 'shake .3s' : removing === card.id ? 'cardRemove var(--dur-base) forwards' : 'none',
              filter: canPlay ? 'drop-shadow(0 0 10px rgba(255,225,90,.7))' : 'none',
            }}>
              <PlayingCard n={card.n} suit={card.suit}
                style={{width: cardW, height: cardW * 1.4}}
                onClick={() => handleCard(card)}/>
            </div>
          );
        })}
      </div>

      {/* Bottom-left: Cat mascot + chest */}
      <div style={{position: 'absolute', bottom: -10, left: 0, zIndex: 5}}>
        <MascotChest contents={boxContents} showBubble={chestBubble}
          onPressStart={() => setChestBubble(true)}
          onPressEnd={() => setChestBubble(false)}/>
      </div>

      {/* Bottom-center: Stock + Waste */}
      <div style={{position: 'absolute', bottom: 24, left: '50%', transform: 'translateX(-50%)',
        display: 'flex', alignItems: 'flex-end', gap: 8, zIndex: 5,
      }}>
        {/* Stock */}
        <div style={{position: 'relative', width: 88, height: 124}}>
          {stockExhausted ? (
            <div style={{display: 'flex', flexDirection: 'column', gap: 4, alignItems: 'center'}}>
              <button onClick={() => setShowGiveUp(true)} style={{
                border: 0, cursor: 'pointer', background: 'rgba(232,64,74,.92)', color: '#fff',
                fontFamily: 'var(--font-display)', fontWeight: 800, fontSize: 11,
                padding: '3px 12px', borderRadius: 999, letterSpacing: '.08em',
                boxShadow: '0 2px 4px rgba(0,0,0,.4)',
              }}>포기</button>
              <div onClick={handleExtraDeck} style={{cursor: 'pointer',
                filter: 'drop-shadow(0 4px 6px rgba(0,0,0,.5))',
                animation: 'pulse 1.6s ease-in-out infinite',
              }}>
                <Icon name="extraDeck" size={88}/>
              </div>
            </div>
          ) : (
            <div onClick={handleDraw} style={{position: 'relative', width: 88, height: 124, cursor: 'pointer'}}>
              {/* Stack of face-down cards — show many for the "thick" look */}
              {Array.from({length: Math.min(stock.length, 8)}).map((_, i) => (
                <PlayingCard key={i} faceDown style={{
                  position: 'absolute', left: i * 1.5, top: -i * 1.5,
                  width: 84, height: 118,
                }}/>
              ))}
              {/* Count */}
              <div style={{
                position: 'absolute', bottom: -10, left: '50%', transform: 'translateX(-50%)',
                background: 'rgba(0,0,0,.7)', color: '#fff',
                padding: '2px 10px', borderRadius: 999,
                fontFamily: 'var(--font-display)', fontWeight: 900, fontSize: 12,
                border: '1.5px solid rgba(255,255,255,.4)',
              }}>{stock.length}</div>
            </div>
          )}
        </div>
        {/* Waste */}
        <div style={{}}>
          {wildInWaste ? (
            <div style={{
              width: 76, height: 106, borderRadius: 8,
              background: 'linear-gradient(135deg, #e878f0, #7030c0)',
              border: '3px solid #fff',
              display:'flex', alignItems:'center', justifyContent:'center',
              fontFamily:'var(--font-display)', fontWeight:900, fontSize:14, color:'#fff',
              letterSpacing: '.08em',
              boxShadow: '0 5px 0 rgba(0,0,0,.55), 0 0 18px rgba(232,120,240,.8)',
              animation: 'pulse 1.2s ease-in-out infinite',
            }}>WILD</div>
          ) : (
            <PlayingCard n={waste.n} suit={waste.suit}
              style={{width: 76, height: 106, boxShadow: '0 5px 0 rgba(0,0,0,.55), 0 0 14px rgba(255,225,90,.4)'}}/>
          )}
        </div>
      </div>

      {/* Bottom-right: Wild booster + Undo (small, floating left of Wild) */}
      <div style={{position: 'absolute', bottom: 22, right: 18, display: 'flex', alignItems: 'flex-end', gap: 12, zIndex: 5}}>
        <UndoBooster count={undoCount} price={UNDO_COST} onClick={handleUndo}/>
        <WildBooster count={wildCount} price={WILD_COST} onClick={handleWild}/>
      </div>

      {/* Popups */}
      {showAdPopup && <NoGoldAdPopup needed={adNeeded}
        onClose={() => setShowAdPopup(false)}
        onWatchAd={() => { setGold(g => g + adNeeded); setShowAdPopup(false); }}/>}
      {showGiveUp && <GiveUpPopup onCancel={() => setShowGiveUp(false)}
        onConfirm={() => { setShowGiveUp(false); onHome(); }}/>}
      {showSettings && <IngameSettingsPopup onClose={() => setShowSettings(false)} onHome={onHome}/>}
    </div>
  );
};

window.IngameScreen = IngameScreen;
