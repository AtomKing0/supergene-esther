// Primitives — now asset-free, uses SVG Icon instead of <img src>.

const Button = ({variant = 'primary', children, onClick, disabled, style, size = 'md'}) => {
  const [pressed, setPressed] = React.useState(false);
  const variants = {
    primary: 'linear-gradient(180deg, var(--brand-orange-300), var(--brand-orange-500))',
    secondary: 'linear-gradient(180deg, var(--brand-blue-300), var(--brand-blue-500))',
    confirm: 'linear-gradient(180deg, var(--brand-green-300), var(--brand-green-500))',
    ghost: 'transparent',
  };
  const sizes = {
    sm: {padding: '8px 18px', fontSize: 13},
    md: {padding: '14px 28px', fontSize: 16},
    lg: {padding: '18px 40px', fontSize: 20},
  };
  return (
    <button
      onClick={() => !disabled && onClick && onClick()}
      onMouseDown={() => setPressed(true)}
      onMouseUp={() => setPressed(false)}
      onMouseLeave={() => setPressed(false)}
      disabled={disabled}
      style={{
        border: 0,
        cursor: disabled ? 'not-allowed' : 'pointer',
        borderRadius: 'var(--r-lg)',
        fontFamily: 'var(--font-display)',
        fontWeight: 800,
        color: variant === 'ghost' ? 'var(--ink-700)' : '#fff',
        letterSpacing: '.02em',
        textShadow: variant === 'ghost' ? 'none' : '0 1px 0 rgba(0,0,0,.25)',
        background: variants[variant],
        boxShadow: pressed
          ? 'var(--shadow-stamp-sm), inset 0 2px 0 rgba(255,255,255,.3)'
          : 'var(--shadow-stamp-lg), inset 0 2px 0 rgba(255,255,255,.3)',
        transform: pressed ? 'translateY(3px)' : 'translateY(0)',
        transition: 'all var(--dur-fast)',
        filter: disabled ? 'saturate(.25) brightness(.95)' : 'none',
        opacity: disabled ? 0.65 : 1,
        ...sizes[size],
        ...style,
      }}>
      {children}
    </button>
  );
};

const IconBtn = ({icon, onClick, size = 44, style}) => (
  <button onClick={onClick} style={{
    width: size, height: size, borderRadius: 999, border: 0, cursor: 'pointer',
    background: 'linear-gradient(180deg,#fff,#f0e2c7)',
    boxShadow: 'var(--shadow-stamp-md), inset 0 2px 0 rgba(255,255,255,.5)',
    display: 'flex', alignItems: 'center', justifyContent: 'center',
    padding: 0, ...style,
  }}>
    <Icon name={icon} size={size * 0.62} />
  </button>
);

const CurrencyPill = ({icon, value, onAdd, dark = true}) => (
  <div style={{
    display: 'inline-flex', alignItems: 'center',
    background: dark ? 'linear-gradient(180deg,#2a1a10,#150a04)' : '#fff',
    color: dark ? '#fff' : 'var(--ink-900)',
    padding: '6px 28px 6px 36px',
    borderRadius: 999, position: 'relative',
    boxShadow: 'inset 0 2px 4px rgba(0,0,0,.5), 0 2px 0 rgba(58,30,14,.35)',
    fontFamily: 'var(--font-display)', fontWeight: 800, fontSize: 15,
    minHeight: 30,
  }}>
    <div style={{
      position: 'absolute', left: -6, top: '50%', transform: 'translateY(-50%)',
      filter: 'drop-shadow(0 2px 3px rgba(0,0,0,.4))',
    }}>
      <Icon name={icon} size={38} />
    </div>
    <span style={{fontVariantNumeric: 'tabular-nums'}}>{value.toLocaleString()}</span>
    {onAdd && (
      <button onClick={onAdd} style={{
        position: 'absolute', right: -4, top: '50%', transform: 'translateY(-50%)',
        width: 22, height: 22, border: 0, background: 'var(--brand-green-400)',
        color: '#fff', borderRadius: 999, fontSize: 16, fontWeight: 800,
        boxShadow: 'var(--shadow-stamp-sm)', cursor: 'pointer', padding: 0, lineHeight: 1,
      }}>+</button>
    )}
  </div>
);

// SvgCard is used as PlayingCard alias
const PlayingCard = (props) => <SvgCard {...props} />;

const Popup = ({title, children, onClose, width = 300}) => (
  <div style={{
    position: 'absolute', inset: 0,
    background: 'rgba(31,43,82,.72)',
    backdropFilter: 'blur(4px)',
    display: 'flex', alignItems: 'center', justifyContent: 'center',
    zIndex: 100,
    animation: 'fadeIn var(--dur-base) var(--ease-out-soft)',
  }}>
    <div style={{
      background: 'var(--paper-50)',
      borderRadius: 'var(--r-2xl)',
      width, maxWidth: 'calc(100% - 32px)',
      padding: '44px 20px 22px',
      position: 'relative',
      boxShadow: 'var(--shadow-drop-lg), var(--shadow-stamp-lg)',
      animation: 'popIn var(--dur-base) var(--ease-out-back)',
    }}>
      {title && (
        <div style={{
          position: 'absolute', top: -20, left: '50%', transform: 'translateX(-50%)',
          background: 'linear-gradient(180deg, var(--brand-orange-300), var(--brand-orange-500))',
          color: '#fff', fontFamily: 'var(--font-display)', fontWeight: 800,
          fontSize: 20, padding: '10px 32px',
          borderRadius: 'var(--r-lg)',
          boxShadow: 'var(--shadow-stamp-md)',
          textShadow: '0 1px 0 rgba(0,0,0,.25)',
          whiteSpace: 'nowrap',
        }}>
          {title}
        </div>
      )}
      {onClose && (
        <button onClick={onClose} style={{
          position: 'absolute', top: -10, right: -10,
          width: 34, height: 34, border: 0, borderRadius: 999,
          background: '#fff', boxShadow: 'var(--shadow-stamp-md)',
          cursor: 'pointer', padding: 0, display: 'flex', alignItems: 'center', justifyContent: 'center',
        }}>
          <Icon name="close" size={18} />
        </button>
      )}
      {children}
    </div>
  </div>
);

Object.assign(window, {Button, IconBtn, CurrencyPill, PlayingCard, Popup});
