// LobbyScreen — LANDSCAPE, asset-free. CSS cityscape + SVG icons.

const LobbyScreen = ({gold, hammers, level, cityIdx, onPlay, onDecorate, onAddGold, onOpenEvent, onOpenRoulette}) => {
  const hues = [30, 180, 280, 110];
  return (
    <div style={{position: 'absolute', inset: 0}}>
      <Cityscape hue={hues[cityIdx % 4]} />

      {/* Top HUD bar */}
      <div style={{position:'absolute', top:0, left:0, right:0, padding:'16px 24px',
        display:'flex', alignItems:'center', justifyContent:'space-between', gap:16,
        background:'linear-gradient(180deg, rgba(0,0,0,.35), rgba(0,0,0,0))', zIndex:5,
      }}>
        <div style={{display:'flex', gap:16, alignItems:'center'}}>
          <div style={{
            background: 'linear-gradient(180deg, var(--brand-orange-300), var(--brand-orange-500))',
            color: '#fff', fontFamily: 'var(--font-display)', fontWeight: 800,
            padding: '8px 22px', borderRadius: 'var(--r-lg)',
            boxShadow: 'var(--shadow-stamp-md)',
            fontSize: 20, textShadow: '0 1px 0 rgba(0,0,0,.25)',
          }}>Paris · City {cityIdx + 1}</div>
        </div>
        <div style={{display: 'flex', gap: 14, alignItems:'center'}}>
          <CurrencyPill icon="coin" value={gold} onAdd={onAddGold} />
          <CurrencyPill icon="hammer" value={hammers} />
          <IconBtn icon="setting" size={48} />
        </div>
      </div>

      {/* Left rail */}
      <div style={{position: 'absolute', left: 18, top: 140, zIndex:5,
        display: 'flex', flexDirection: 'column', gap: 14}}>
        <IconBtn icon="tournament" size={64} />
        <div style={{position:'relative'}}>
          <IconBtn icon="roulette" size={64} onClick={onOpenRoulette} />
          <div style={{position:'absolute', top:-4, right:-4,
            background:'#ff4060', color:'#fff', fontSize: 10, fontWeight:900,
            padding:'2px 6px', borderRadius: 999, border:'2px solid #fff',
            fontFamily:'var(--font-display)', letterSpacing:'.04em',
          }}>3</div>
        </div>
        <div style={{position:'relative'}}>
          <IconBtn icon="firecracker" size={64} onClick={onOpenEvent} />
          <div style={{position:'absolute', top:-4, right:-4,
            background:'#ff4060', color:'#fff', fontSize: 10, fontWeight:900,
            padding:'2px 6px', borderRadius: 999, border:'2px solid #fff',
            fontFamily:'var(--font-display)', letterSpacing:'.04em',
          }}>NEW</div>
        </div>
        <IconBtn icon="task" size={64} />
      </div>

      {/* Right rail */}
      <div style={{position: 'absolute', right: 18, top: 140, zIndex:5,
        display: 'flex', flexDirection: 'column', gap: 14}}>
        <IconBtn icon="leaderboard" size={64} />
        <IconBtn icon="inbox" size={64} />
        <IconBtn icon="collection" size={64} />
      </div>

      {/* Bottom dock */}
      <div style={{position:'absolute', left:0, right:0, bottom:0, padding:'18px 110px 22px',
        display:'flex', alignItems:'flex-end', justifyContent:'space-between', gap:20, zIndex:5,
        background:'linear-gradient(0deg, rgba(0,0,0,.4), rgba(0,0,0,0))',
      }}>
        {hammers > 0 ? (
          <div onClick={onDecorate} style={{
            padding: '12px 18px', display: 'flex', alignItems: 'center', gap: 12,
            background: 'rgba(255,248,236,.96)',
            borderRadius: 'var(--r-lg)',
            boxShadow: 'var(--shadow-stamp-md)',
            cursor: 'pointer', minWidth: 260,
          }}>
            <Icon name="decorate" size={52} />
            <div style={{flex: 1}}>
              <div style={{fontFamily: 'var(--font-display)', fontWeight: 700, fontSize: 18, color: 'var(--ink-900)'}}>
                Hammer ready!
              </div>
              <div style={{fontSize: 13, color: 'var(--ink-500)'}}>Decorate your city →</div>
            </div>
          </div>
        ) : <div style={{minWidth:260}} />}

        <div style={{textAlign: 'center'}}>
          <div style={{
            fontFamily: 'var(--font-display)', fontWeight: 800, fontSize: 22,
            color: '#fff', textShadow: '0 2px 4px rgba(0,0,0,.6)', marginBottom: 8,
          }}>Level {level}</div>
          <Button variant="primary" size="lg" onClick={onPlay} style={{minWidth: 280, fontSize: 30, padding:'16px 36px'}}>
            Play
          </Button>
        </div>
      </div>
    </div>
  );
};

window.LobbyScreen = LobbyScreen;
