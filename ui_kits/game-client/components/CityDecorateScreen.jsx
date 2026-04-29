// CityDecorateScreen — LANDSCAPE, asset-free.

const CityDecorateScreen = ({hammers, gold, cityIdx, upgrades, onUpgrade, onHome}) => {
  const buildings = [
    {id: 0, name: 'Fountain', x: 14, y: 60, cost: 1, gCost: 0},
    {id: 1, name: 'Café',     x: 30, y: 52, cost: 1, gCost: 100},
    {id: 2, name: 'Tower',    x: 48, y: 44, cost: 2, gCost: 200},
    {id: 3, name: 'Gallery',  x: 66, y: 54, cost: 2, gCost: 300},
    {id: 4, name: 'Garden',   x: 84, y: 60, cost: 3, gCost: 500},
  ];
  const [selected, setSelected] = React.useState(null);
  const sel = buildings.find(b => b.id === selected);
  const hues = [30, 180, 280, 110];

  return (
    <div style={{position: 'absolute', inset: 0}}>
      <Cityscape hue={hues[cityIdx % 4]} />

      <div style={{position:'absolute', top:0, left:0, right:0, padding: '16px 22px',
        display: 'flex', alignItems: 'center', gap: 14, zIndex:5,
        background:'linear-gradient(180deg, rgba(0,0,0,.35), rgba(0,0,0,0))'}}>
        <IconBtn icon="home" size={48} onClick={onHome} />
        <div style={{flex: 1, textAlign: 'center'}}>
          <div style={{
            display: 'inline-block',
            background: 'linear-gradient(180deg, var(--brand-orange-300), var(--brand-orange-500))',
            color: '#fff', padding: '8px 30px', borderRadius: 'var(--r-lg)',
            fontFamily: 'var(--font-display)', fontWeight: 800, fontSize: 20,
            boxShadow: 'var(--shadow-stamp-md)', textShadow: '0 1px 0 rgba(0,0,0,.25)',
          }}>Decorate Paris</div>
        </div>
        <div style={{display: 'flex', gap: 12}}>
          <CurrencyPill icon="coin" value={gold} />
          <CurrencyPill icon="hammer" value={hammers} />
        </div>
      </div>

      {buildings.map(b => {
        const stage = upgrades[b.id] || 0;
        return (
          <button key={b.id}
            onClick={() => setSelected(b.id)}
            style={{
              position: 'absolute', zIndex:4,
              left: `${b.x}%`, top: `${b.y}%`,
              transform: 'translate(-50%, -50%)',
              width: 72, height: 72, borderRadius: 999, border: 0,
              background: stage === 2 ? 'var(--brand-green-400)'
                : stage === 1 ? 'var(--brand-orange-400)' : 'rgba(255,255,255,.92)',
              boxShadow: 'var(--shadow-stamp-md), 0 0 20px rgba(255,225,138,.65)',
              cursor: 'pointer', animation: stage < 2 ? 'pulse 2s infinite' : 'none',
              display: 'flex', alignItems: 'center', justifyContent: 'center', padding: 0,
            }}>
            <Icon name={stage === 2 ? 'check' : 'upgrade'} size={50} />
          </button>
        );
      })}

      {sel && (
        <Popup title={sel.name} onClose={() => setSelected(null)} width={360}>
          <div style={{textAlign: 'center'}}>
            <div style={{
              margin: '4px auto 16px', width: 160, height: 130,
              borderRadius: 'var(--r-lg)', background: 'var(--paper-200)',
              boxShadow: 'var(--shadow-inset)',
              display: 'flex', alignItems: 'center', justifyContent: 'center',
            }}>
              <Icon name={upgrades[sel.id] === 2 ? 'crown' : 'upgrade'} size={80} />
            </div>
            {upgrades[sel.id] === 2 ? (
              <>
                <p style={{margin: '0 0 14px', fontWeight: 700, color: 'var(--brand-green-500)'}}>Fully upgraded!</p>
                <Button variant="secondary" onClick={() => setSelected(null)} style={{width: '100%'}}>Nice</Button>
              </>
            ) : (
              <>
                <p style={{margin: '0 0 14px', color: 'var(--ink-500)', fontSize: 14}}>
                  Stage {(upgrades[sel.id] || 0) + 1} of 2
                </p>
                <div style={{display: 'flex', justifyContent: 'center', gap: 14, margin: '0 0 16px'}}>
                  <div style={{display: 'flex', alignItems: 'center', gap: 6,
                    background: 'var(--paper-100)', borderRadius: 999,
                    padding: '6px 16px 6px 8px', boxShadow: 'var(--shadow-inset)'}}>
                    <Icon name="hammer" size={28} />
                    <b style={{fontFamily: 'var(--font-display)',
                      color: hammers >= sel.cost ? 'var(--ink-900)' : 'var(--danger)'}}>{sel.cost}</b>
                  </div>
                  {sel.gCost > 0 && (
                    <div style={{display: 'flex', alignItems: 'center', gap: 6,
                      background: 'var(--paper-100)', borderRadius: 999,
                      padding: '6px 16px 6px 8px', boxShadow: 'var(--shadow-inset)'}}>
                      <Icon name="coin" size={28} />
                      <b style={{fontFamily: 'var(--font-display)',
                        color: gold >= sel.gCost ? 'var(--ink-900)' : 'var(--danger)'}}>{sel.gCost}</b>
                    </div>
                  )}
                </div>
                <Button variant="confirm"
                  onClick={() => {onUpgrade(sel.id, sel.cost, sel.gCost); setSelected(null);}}
                  disabled={hammers < sel.cost || gold < sel.gCost}
                  style={{width: '100%'}}>Upgrade</Button>
              </>
            )}
          </div>
        </Popup>
      )}
    </div>
  );
};

window.CityDecorateScreen = CityDecorateScreen;
