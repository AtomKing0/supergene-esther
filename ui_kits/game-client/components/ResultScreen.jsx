// ResultScreen — clear + fail variants, asset-free.

const ResultScreen = ({variant, level, goldReward, hammerReward, onNext, onHome, onContinue}) => {
  const [goldCount, setGoldCount] = React.useState(0);
  const [hammerCount, setHammerCount] = React.useState(0);

  React.useEffect(() => {
    if (variant !== 'clear') return;
    let g = 0;
    const gi = setInterval(() => {
      g = Math.min(g + Math.ceil(goldReward / 40), goldReward);
      setGoldCount(g);
      if (g >= goldReward) clearInterval(gi);
    }, 25);
    const hi = setTimeout(() => setHammerCount(hammerReward), 600);
    return () => {clearInterval(gi); clearTimeout(hi);};
  }, [variant, goldReward, hammerReward]);

  if (variant === 'fail') {
    return (
      <div style={{position: 'absolute', inset: 0, background: 'rgba(31,43,82,.88)', backdropFilter: 'blur(4px)', display: 'flex', alignItems: 'center', justifyContent: 'center'}}>
        <div style={{
          background: 'var(--paper-50)', borderRadius: 'var(--r-2xl)', width: 340,
          padding: '28px 22px 22px', textAlign: 'center',
          boxShadow: 'var(--shadow-drop-lg), var(--shadow-stamp-lg)',
          animation: 'popIn var(--dur-base) var(--ease-out-back)',
        }}>
          <div style={{fontSize: 54, marginBottom: 8}}>😮</div>
          <h2 style={{margin: '0 0 6px'}}>So close!</h2>
          <p style={{margin: '0 0 18px', color: 'var(--ink-500)', fontSize: 13}}>Keep going with 50g?</p>
          <div style={{display: 'flex', gap: 10, flexDirection: 'column'}}>
            <Button variant="primary" onClick={onContinue} style={{width: '100%'}}>Continue · 50g</Button>
            <Button variant="ghost" size="sm" onClick={onHome} style={{
              color: 'var(--ink-500)', textShadow: 'none', background: 'transparent', boxShadow: 'none',
            }}>Back to lobby</Button>
          </div>
        </div>
      </div>
    );
  }

  return (
    <div style={{position: 'absolute', inset: 0, background: 'radial-gradient(ellipse at center, rgba(248,128,24,.55) 0%, rgba(31,43,82,.9) 70%)', display: 'flex', alignItems: 'center', justifyContent: 'center'}}>
      <div style={{
        background: 'var(--paper-50)', borderRadius: 'var(--r-2xl)', width: 340,
        padding: '58px 22px 22px', textAlign: 'center', position: 'relative',
        boxShadow: 'var(--shadow-drop-lg), var(--shadow-stamp-lg)',
        animation: 'popIn var(--dur-slow) var(--ease-out-back)',
      }}>
        <div style={{
          position: 'absolute', top: -46, left: '50%', transform: 'translateX(-50%)',
          filter: 'drop-shadow(0 6px 10px rgba(0,0,0,.3))',
        }}>
          <Icon name="crown" size={96} />
        </div>

        <h1 className="hero" style={{
          fontSize: 36, color: 'var(--brand-orange-400)',
          textShadow: '0 2px 0 var(--brand-orange-600), 0 4px 0 var(--brand-orange-700), 0 6px 12px rgba(0,0,0,.2)',
          margin: '8px 0 4px',
        }}>Clear!</h1>
        <p style={{margin: '0 0 14px', color: 'var(--ink-500)', fontSize: 13}}>Nice one · Level {level}</p>

        <div style={{display: 'flex', justifyContent: 'center', gap: 8, margin: '0 0 18px'}}>
          {[1, 2, 3].map(i => (
            <div key={i} style={{
              filter: 'drop-shadow(0 0 10px var(--gold-glow))',
              animation: `popIn var(--dur-base) var(--ease-out-back) ${i * 120}ms backwards`,
            }}>
              <Icon name="star" size={48} />
            </div>
          ))}
        </div>

        <div style={{
          background: 'var(--paper-100)', borderRadius: 'var(--r-md)',
          boxShadow: 'var(--shadow-inset)', padding: '10px 14px',
          margin: '0 0 18px', display: 'flex', justifyContent: 'space-around',
        }}>
          <div style={{display: 'flex', alignItems: 'center', gap: 8}}>
            <Icon name="coin" size={36} />
            <div style={{fontFamily: 'var(--font-display)', fontWeight: 800, color: 'var(--ink-900)', fontSize: 20, fontVariantNumeric: 'tabular-nums'}}>
              +{goldCount.toLocaleString()}
            </div>
          </div>
          <div style={{display: 'flex', alignItems: 'center', gap: 8}}>
            <Icon name="hammer" size={34} />
            <div style={{fontFamily: 'var(--font-display)', fontWeight: 800, color: 'var(--ink-900)', fontSize: 20}}>
              +{hammerCount}
            </div>
          </div>
        </div>

        <div style={{display: 'flex', gap: 10}}>
          <Button variant="secondary" size="md" onClick={onHome} style={{flex: 1}}>Lobby</Button>
          <Button variant="primary" size="md" onClick={onNext} style={{flex: 1.5}}>Next Level</Button>
        </div>
      </div>
    </div>
  );
};

window.ResultScreen = ResultScreen;
