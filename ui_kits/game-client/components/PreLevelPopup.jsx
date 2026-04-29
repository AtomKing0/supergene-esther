// PreLevelPopup — bet x1/x2/x4, asset-free.

const PreLevelPopup = ({level, onClose, onPlay}) => {
  const [bet, setBet] = React.useState(1);
  const bets = [
    {mult: 1, fee: 50, reward: 200, color: 'var(--brand-green-400)', label: 'Safe', locked: false},
    {mult: 2, fee: 100, reward: 400, color: 'var(--brand-orange-400)', label: 'Double', locked: level < 3},
    {mult: 4, fee: 200, reward: 800, color: '#8A2FBF', label: 'High risk', locked: level < 10},
  ];
  const current = bets.find(b => b.mult === bet);

  return (
    <Popup title={`Level ${level}`} onClose={onClose} width={340}>
      <div style={{textAlign: 'center', marginTop: 6}}>
        <p style={{margin: '0 0 14px', color: 'var(--ink-500)', fontSize: 13}}>
          Feeling lucky? Bet more to win more.
        </p>

        <div style={{display: 'flex', justifyContent: 'center', gap: 10, margin: '6px 0 16px'}}>
          {bets.map(b => (
            <button key={b.mult}
              onClick={() => !b.locked && setBet(b.mult)}
              disabled={b.locked}
              style={{
                width: 82, height: 84, border: 0, borderRadius: 'var(--r-xl)',
                cursor: b.locked ? 'not-allowed' : 'pointer',
                background: b.locked
                  ? 'linear-gradient(180deg,#A89685,#6D5A48)'
                  : `linear-gradient(180deg, ${b.color}, color-mix(in srgb, ${b.color} 60%, black))`,
                color: '#fff', fontFamily: 'var(--font-display)', fontWeight: 800,
                boxShadow: bet === b.mult
                  ? 'var(--shadow-stamp-lg), var(--glow-gold)'
                  : 'var(--shadow-stamp-md)',
                transform: bet === b.mult ? 'translateY(-4px) scale(1.05)' : 'none',
                transition: 'all var(--dur-base)',
                opacity: b.locked ? 0.7 : 1,
                position: 'relative',
              }}>
              <div style={{fontSize: 28, lineHeight: 1, textShadow: '0 2px 0 rgba(0,0,0,.3)'}}>x{b.mult}</div>
              <div style={{fontSize: 9, textTransform: 'uppercase', letterSpacing: '.08em', marginTop: 3, opacity: 0.9}}>
                {b.locked ? `Lv ${b.mult === 2 ? 3 : 10}` : b.label}
              </div>
              {b.locked && (
                <div style={{position: 'absolute', top: 4, right: 4, fontSize: 14}}>🔒</div>
              )}
            </button>
          ))}
        </div>

        <div style={{
          background: 'var(--paper-100)',
          borderRadius: 'var(--r-md)',
          boxShadow: 'var(--shadow-inset)',
          padding: '10px 14px', margin: '0 0 14px',
          display: 'flex', justifyContent: 'space-between',
        }}>
          <div>
            <div style={{fontSize: 10, color: 'var(--ink-500)', textTransform: 'uppercase', letterSpacing: '.06em', fontWeight: 700}}>Entry</div>
            <div style={{fontFamily: 'var(--font-display)', fontWeight: 800, color: 'var(--ink-900)', fontSize: 18}}>
              {current.fee}g
            </div>
          </div>
          <div style={{borderRight: '1px dashed var(--ink-300)'}} />
          <div>
            <div style={{fontSize: 10, color: 'var(--ink-500)', textTransform: 'uppercase', letterSpacing: '.06em', fontWeight: 700}}>Reward</div>
            <div style={{fontFamily: 'var(--font-display)', fontWeight: 800, color: 'var(--brand-orange-500)', fontSize: 18}}>
              {current.reward}g
            </div>
          </div>
        </div>

        <div style={{display: 'flex', justifyContent: 'center', gap: 10, margin: '0 0 16px'}}>
          {['bomb','wild','undo'].map(name => (
            <div key={name} style={{
              width: 56, height: 56, borderRadius: 'var(--r-md)',
              background: 'var(--paper-200)', boxShadow: 'var(--shadow-inset)',
              display: 'flex', alignItems: 'center', justifyContent: 'center',
              position: 'relative', opacity: 0.55,
            }}>
              <Icon name={name} size={40} />
              <div style={{position: 'absolute', bottom: 2, right: 4, fontSize: 10}}>🔒</div>
            </div>
          ))}
        </div>

        <Button variant="primary" size="lg" onClick={() => onPlay(bet)} style={{width: '100%'}}>
          Play · {current.fee}g
        </Button>
      </div>
    </Popup>
  );
};

window.PreLevelPopup = PreLevelPopup;
