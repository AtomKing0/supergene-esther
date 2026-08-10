/* @ds-bundle: {"format":4,"namespace":"CozyCottageDesignSystem_d8a5c0","components":[{"name":"Button","sourcePath":"components/buttons/Button.jsx"},{"name":"IconButton","sourcePath":"components/buttons/IconButton.jsx"},{"name":"Badge","sourcePath":"components/display/Badge.jsx"},{"name":"Card","sourcePath":"components/display/Card.jsx"},{"name":"Tag","sourcePath":"components/display/Tag.jsx"},{"name":"Dialog","sourcePath":"components/feedback/Dialog.jsx"},{"name":"Toast","sourcePath":"components/feedback/Toast.jsx"},{"name":"Tooltip","sourcePath":"components/feedback/Tooltip.jsx"},{"name":"ProgressBar","sourcePath":"components/game/ProgressBar.jsx"},{"name":"ResourceChip","sourcePath":"components/game/ResourceChip.jsx"},{"name":"Checkbox","sourcePath":"components/inputs/Checkbox.jsx"},{"name":"Input","sourcePath":"components/inputs/Input.jsx"},{"name":"Radio","sourcePath":"components/inputs/Radio.jsx"},{"name":"Select","sourcePath":"components/inputs/Select.jsx"},{"name":"Switch","sourcePath":"components/inputs/Switch.jsx"},{"name":"Tabs","sourcePath":"components/navigation/Tabs.jsx"}],"sourceHashes":{"components/buttons/Button.jsx":"0fc75d7cb83f","components/buttons/IconButton.jsx":"9c36183b9ceb","components/display/Badge.jsx":"bd6af7b94903","components/display/Card.jsx":"e5fd1dec5391","components/display/Tag.jsx":"f0a9bc41708c","components/feedback/Dialog.jsx":"1f78ecfcbf9c","components/feedback/Toast.jsx":"48285dabe873","components/feedback/Tooltip.jsx":"543b5bbf9136","components/game/ProgressBar.jsx":"95d5a07aeeb0","components/game/ResourceChip.jsx":"04bcd8bc9fd1","components/inputs/Checkbox.jsx":"ff69bdb9ba4a","components/inputs/Input.jsx":"31859f4e8cb1","components/inputs/Radio.jsx":"d859e20afec6","components/inputs/Select.jsx":"546986f0fe17","components/inputs/Switch.jsx":"70f46020ea45","components/navigation/Tabs.jsx":"9af30de10725","ui_kits/merge-game/App.jsx":"0453ba6c5fd0","ui_kits/merge-game/GardenScreen.jsx":"53f328ce2cdc","ui_kits/merge-game/SettingsScreen.jsx":"41501c8319ef","ui_kits/merge-game/StoryScreen.jsx":"6501c9f2d861"},"inlinedExternals":[],"unexposedExports":[]} */

(() => {

const __ds_ns = (window.CozyCottageDesignSystem_d8a5c0 = window.CozyCottageDesignSystem_d8a5c0 || {});

const __ds_scope = {};

(__ds_ns.__errors = __ds_ns.__errors || []);

// components/buttons/Button.jsx
try { (() => {
const CC_BTN_PALETTES = {
  coral: {
    bg: 'var(--coral-500)',
    edge: 'var(--edge-coral)',
    text: 'var(--white)'
  },
  leaf: {
    bg: 'var(--leaf-600)',
    edge: 'var(--edge-leaf)',
    text: 'var(--white)'
  },
  gold: {
    bg: 'var(--gold-500)',
    edge: 'var(--edge-gold)',
    text: 'var(--white)'
  },
  lavender: {
    bg: 'var(--lavender-500)',
    edge: 'var(--edge-lavender)',
    text: 'var(--white)'
  },
  cream: {
    bg: 'var(--butter-100)',
    edge: 'var(--edge-neutral)',
    text: 'var(--ink-900)'
  }
};
const CC_BTN_SIZES = {
  md: {
    h: 48,
    pad: '0 24px',
    font: 'var(--text-md)',
    icon: 22
  },
  lg: {
    h: 56,
    pad: '0 32px',
    font: 'var(--text-lg)',
    icon: 26
  },
  xl: {
    h: 64,
    pad: '0 40px',
    font: 'var(--text-xl)',
    icon: 30
  }
};
function Button({
  color = 'coral',
  size = 'lg',
  icon,
  children,
  disabled,
  onClick,
  fullWidth,
  style
}) {
  const [pressed, setPressed] = React.useState(false);
  const [hover, setHover] = React.useState(false);
  const p = CC_BTN_PALETTES[color] || CC_BTN_PALETTES.coral;
  const s = CC_BTN_SIZES[size] || CC_BTN_SIZES.lg;
  const down = pressed && !disabled;
  return /*#__PURE__*/React.createElement("button", {
    onClick: onClick,
    disabled: disabled,
    onMouseEnter: () => setHover(true),
    onMouseLeave: () => {
      setHover(false);
      setPressed(false);
    },
    onMouseDown: () => setPressed(true),
    onMouseUp: () => setPressed(false),
    onTouchStart: () => setPressed(true),
    onTouchEnd: () => setPressed(false),
    style: {
      fontFamily: 'var(--font-display)',
      fontWeight: 700,
      fontSize: s.font,
      color: p.text,
      background: p.bg,
      border: 'none',
      borderRadius: 'var(--radius-pill)',
      height: s.h,
      padding: s.pad,
      minWidth: 'var(--tap-min)',
      width: fullWidth ? '100%' : undefined,
      display: 'inline-flex',
      alignItems: 'center',
      justifyContent: 'center',
      gap: 10,
      cursor: disabled ? 'default' : 'pointer',
      opacity: disabled ? 0.45 : 1,
      boxShadow: down ? `0 1px 0 ${p.edge}` : `0 var(--edge-height) 0 ${p.edge}, var(--shadow-soft)`,
      transform: down ? 'translateY(3px)' : 'translateY(0)',
      filter: hover && !disabled && !down ? 'brightness(1.06)' : 'none',
      transition: 'transform var(--transition-quick), box-shadow var(--transition-quick), filter var(--transition-quick)',
      ...style
    }
  }, icon ? /*#__PURE__*/React.createElement("span", {
    className: "cc-icon",
    style: {
      fontSize: s.icon
    }
  }, icon) : null, children);
}
Object.assign(__ds_scope, { Button });
})(); } catch (e) { __ds_ns.__errors.push({ path: "components/buttons/Button.jsx", error: String((e && e.message) || e) }); }

// components/buttons/IconButton.jsx
try { (() => {
function IconButton({
  color = 'cream',
  size = 56,
  icon = 'settings',
  label,
  disabled,
  onClick,
  style
}) {
  const palettes = {
    coral: {
      bg: 'var(--coral-500)',
      edge: 'var(--edge-coral)',
      text: 'var(--white)'
    },
    leaf: {
      bg: 'var(--leaf-600)',
      edge: 'var(--edge-leaf)',
      text: 'var(--white)'
    },
    gold: {
      bg: 'var(--gold-500)',
      edge: 'var(--edge-gold)',
      text: 'var(--white)'
    },
    cream: {
      bg: 'var(--white)',
      edge: 'var(--edge-neutral)',
      text: 'var(--ink-700)'
    }
  };
  const [pressed, setPressed] = React.useState(false);
  const p = palettes[color] || palettes.cream;
  const down = pressed && !disabled;
  return /*#__PURE__*/React.createElement("span", {
    style: {
      display: 'inline-flex',
      flexDirection: 'column',
      alignItems: 'center',
      gap: 4,
      ...style
    }
  }, /*#__PURE__*/React.createElement("button", {
    "aria-label": label,
    onClick: onClick,
    disabled: disabled,
    onMouseDown: () => setPressed(true),
    onMouseUp: () => setPressed(false),
    onMouseLeave: () => setPressed(false),
    onTouchStart: () => setPressed(true),
    onTouchEnd: () => setPressed(false),
    style: {
      width: size,
      height: size,
      minWidth: 'var(--tap-min)',
      minHeight: 'var(--tap-min)',
      borderRadius: 'var(--radius-pill)',
      border: 'none',
      background: p.bg,
      color: p.text,
      display: 'inline-flex',
      alignItems: 'center',
      justifyContent: 'center',
      cursor: disabled ? 'default' : 'pointer',
      opacity: disabled ? 0.45 : 1,
      boxShadow: down ? `0 1px 0 ${p.edge}` : `0 var(--edge-height) 0 ${p.edge}, var(--shadow-soft)`,
      transform: down ? 'translateY(3px)' : 'none',
      transition: 'transform var(--transition-quick), box-shadow var(--transition-quick)'
    }
  }, /*#__PURE__*/React.createElement("span", {
    className: "cc-icon",
    style: {
      fontSize: Math.round(size * 0.48)
    }
  }, icon)), label ? /*#__PURE__*/React.createElement("span", {
    style: {
      fontFamily: 'var(--font-body)',
      fontSize: 'var(--text-sm)',
      fontWeight: 'var(--weight-semibold)',
      color: 'var(--text-secondary)'
    }
  }, label) : null);
}
Object.assign(__ds_scope, { IconButton });
})(); } catch (e) { __ds_ns.__errors.push({ path: "components/buttons/IconButton.jsx", error: String((e && e.message) || e) }); }

// components/display/Badge.jsx
try { (() => {
function Badge({
  color = 'coral',
  icon,
  children,
  style
}) {
  const palettes = {
    coral: {
      bg: 'var(--coral-600)',
      text: 'var(--white)'
    },
    leaf: {
      bg: 'var(--leaf-600)',
      text: 'var(--white)'
    },
    gold: {
      bg: 'var(--gold-600)',
      text: 'var(--white)'
    },
    lavender: {
      bg: 'var(--lavender-700)',
      text: 'var(--white)'
    },
    ink: {
      bg: 'var(--ink-700)',
      text: 'var(--white)'
    }
  };
  const p = palettes[color] || palettes.coral;
  return /*#__PURE__*/React.createElement("span", {
    style: {
      display: 'inline-flex',
      alignItems: 'center',
      gap: 6,
      background: p.bg,
      color: p.text,
      fontFamily: 'var(--font-body)',
      fontSize: 'var(--text-sm)',
      fontWeight: 'var(--weight-bold)',
      letterSpacing: 'var(--tracking-caps)',
      textTransform: 'uppercase',
      borderRadius: 'var(--radius-pill)',
      padding: '6px 14px',
      boxShadow: 'var(--sticker-ring)',
      ...style
    }
  }, icon ? /*#__PURE__*/React.createElement("span", {
    className: "cc-icon",
    style: {
      fontSize: 18
    }
  }, icon) : null, children);
}
Object.assign(__ds_scope, { Badge });
})(); } catch (e) { __ds_ns.__errors.push({ path: "components/display/Badge.jsx", error: String((e && e.message) || e) }); }

// components/display/Card.jsx
try { (() => {
function Card({
  tone = 'plain',
  sticker = false,
  padding = 'var(--space-5)',
  children,
  style
}) {
  const tones = {
    plain: 'var(--surface-card)',
    butter: 'var(--surface-butter)',
    story: 'var(--surface-story)',
    garden: 'var(--surface-garden)',
    reward: 'var(--surface-reward)'
  };
  return /*#__PURE__*/React.createElement("div", {
    style: {
      background: tones[tone] || tones.plain,
      borderRadius: 'var(--radius-lg)',
      border: '2px solid var(--border-soft)',
      boxShadow: sticker ? 'var(--sticker-ring), var(--shadow-card)' : 'var(--shadow-card)',
      padding,
      fontFamily: 'var(--font-body)',
      color: 'var(--text-body)',
      boxSizing: 'border-box',
      ...style
    }
  }, children);
}
Object.assign(__ds_scope, { Card });
})(); } catch (e) { __ds_ns.__errors.push({ path: "components/display/Card.jsx", error: String((e && e.message) || e) }); }

// components/display/Tag.jsx
try { (() => {
function Tag({
  color = 'sage',
  icon,
  children,
  style
}) {
  const palettes = {
    sage: {
      bg: 'var(--sage-100)',
      text: 'var(--leaf-700)',
      border: 'var(--sage-300)'
    },
    rose: {
      bg: 'var(--rose-100)',
      text: 'var(--coral-700)',
      border: 'var(--rose-200)'
    },
    gold: {
      bg: 'var(--gold-100)',
      text: 'var(--gold-700)',
      border: 'var(--gold-300)'
    },
    lavender: {
      bg: 'var(--lavender-100)',
      text: 'var(--lavender-700)',
      border: 'var(--lavender-300)'
    },
    butter: {
      bg: 'var(--butter-100)',
      text: 'var(--ink-700)',
      border: 'var(--butter-200)'
    }
  };
  const p = palettes[color] || palettes.sage;
  return /*#__PURE__*/React.createElement("span", {
    style: {
      display: 'inline-flex',
      alignItems: 'center',
      gap: 6,
      background: p.bg,
      color: p.text,
      border: `2px solid ${p.border}`,
      fontFamily: 'var(--font-body)',
      fontSize: 'var(--text-sm)',
      fontWeight: 'var(--weight-bold)',
      borderRadius: 'var(--radius-pill)',
      padding: '6px 14px',
      ...style
    }
  }, icon ? /*#__PURE__*/React.createElement("span", {
    className: "cc-icon",
    style: {
      fontSize: 18
    }
  }, icon) : null, children);
}
Object.assign(__ds_scope, { Tag });
})(); } catch (e) { __ds_ns.__errors.push({ path: "components/display/Tag.jsx", error: String((e && e.message) || e) }); }

// components/feedback/Dialog.jsx
try { (() => {
function Dialog({
  open = true,
  title,
  children,
  actions,
  onClose,
  tone = 'plain',
  width = 400,
  style
}) {
  if (!open) return null;
  const tones = {
    plain: 'var(--surface-card)',
    butter: 'var(--surface-butter)',
    reward: 'var(--surface-reward)',
    story: 'var(--surface-story)'
  };
  return /*#__PURE__*/React.createElement("div", {
    style: {
      position: 'absolute',
      inset: 0,
      background: 'rgba(62, 49, 38, 0.45)',
      display: 'flex',
      alignItems: 'center',
      justifyContent: 'center',
      padding: 'var(--space-5)',
      zIndex: 50,
      boxSizing: 'border-box'
    },
    onClick: onClose
  }, /*#__PURE__*/React.createElement("div", {
    role: "dialog",
    "aria-modal": "true",
    onClick: e => e.stopPropagation(),
    style: {
      background: tones[tone] || tones.plain,
      borderRadius: 'var(--radius-xl)',
      boxShadow: 'var(--sticker-ring), var(--shadow-float)',
      width: '100%',
      maxWidth: width,
      padding: 'var(--space-6)',
      position: 'relative',
      fontFamily: 'var(--font-body)',
      color: 'var(--text-body)',
      textAlign: 'center',
      boxSizing: 'border-box',
      ...style
    }
  }, onClose ? /*#__PURE__*/React.createElement("button", {
    "aria-label": "Close",
    onClick: onClose,
    style: {
      position: 'absolute',
      top: -14,
      right: -14,
      width: 48,
      height: 48,
      borderRadius: '50%',
      border: '3px solid var(--white)',
      background: 'var(--coral-500)',
      color: 'var(--white)',
      cursor: 'pointer',
      display: 'flex',
      alignItems: 'center',
      justifyContent: 'center',
      boxShadow: '0 3px 0 var(--coral-700)'
    }
  }, /*#__PURE__*/React.createElement("span", {
    className: "cc-icon",
    style: {
      fontSize: 26,
      fontVariationSettings: "'FILL' 1, 'wght' 700"
    }
  }, "close")) : null, title ? /*#__PURE__*/React.createElement("h2", {
    style: {
      fontSize: 'var(--text-2xl)',
      marginBottom: 'var(--space-4)'
    }
  }, title) : null, /*#__PURE__*/React.createElement("div", {
    style: {
      fontSize: 'var(--text-md)',
      lineHeight: 'var(--leading-body)'
    }
  }, children), actions ? /*#__PURE__*/React.createElement("div", {
    style: {
      display: 'flex',
      flexDirection: 'column',
      gap: 'var(--space-3)',
      marginTop: 'var(--space-5)'
    }
  }, actions) : null));
}
Object.assign(__ds_scope, { Dialog });
})(); } catch (e) { __ds_ns.__errors.push({ path: "components/feedback/Dialog.jsx", error: String((e && e.message) || e) }); }

// components/feedback/Toast.jsx
try { (() => {
function Toast({
  open = true,
  icon = 'check_circle',
  color = 'leaf',
  children,
  style
}) {
  const palettes = {
    leaf: {
      icon: 'var(--leaf-600)'
    },
    coral: {
      icon: 'var(--coral-500)'
    },
    gold: {
      icon: 'var(--gold-500)'
    }
  };
  if (!open) return null;
  const p = palettes[color] || palettes.leaf;
  return /*#__PURE__*/React.createElement("div", {
    role: "status",
    style: {
      display: 'inline-flex',
      alignItems: 'center',
      gap: 12,
      background: 'var(--ink-900)',
      color: 'var(--cream-50)',
      borderRadius: 'var(--radius-pill)',
      padding: '12px 24px 12px 16px',
      minHeight: 'var(--tap-min)',
      boxShadow: 'var(--shadow-float)',
      fontFamily: 'var(--font-body)',
      fontSize: 'var(--text-md)',
      fontWeight: 'var(--weight-semibold)',
      boxSizing: 'border-box',
      ...style
    }
  }, /*#__PURE__*/React.createElement("span", {
    className: "cc-icon",
    style: {
      fontSize: 28,
      color: p.icon
    }
  }, icon), /*#__PURE__*/React.createElement("span", null, children));
}
Object.assign(__ds_scope, { Toast });
})(); } catch (e) { __ds_ns.__errors.push({ path: "components/feedback/Toast.jsx", error: String((e && e.message) || e) }); }

// components/feedback/Tooltip.jsx
try { (() => {
function Tooltip({
  text,
  children,
  style
}) {
  const [show, setShow] = React.useState(false);
  return /*#__PURE__*/React.createElement("span", {
    style: {
      position: 'relative',
      display: 'inline-flex',
      ...style
    },
    onMouseEnter: () => setShow(true),
    onMouseLeave: () => setShow(false),
    onFocus: () => setShow(true),
    onBlur: () => setShow(false)
  }, children, show ? /*#__PURE__*/React.createElement("span", {
    role: "tooltip",
    style: {
      position: 'absolute',
      bottom: 'calc(100% + 10px)',
      left: '50%',
      transform: 'translateX(-50%)',
      background: 'var(--ink-900)',
      color: 'var(--cream-50)',
      fontFamily: 'var(--font-body)',
      fontSize: 'var(--text-sm)',
      fontWeight: 'var(--weight-semibold)',
      lineHeight: 1.4,
      borderRadius: 'var(--radius-sm)',
      padding: '8px 14px',
      whiteSpace: 'nowrap',
      boxShadow: 'var(--shadow-soft)',
      zIndex: 40
    }
  }, text, /*#__PURE__*/React.createElement("span", {
    style: {
      position: 'absolute',
      top: '100%',
      left: '50%',
      transform: 'translateX(-50%)',
      border: '7px solid transparent',
      borderTopColor: 'var(--ink-900)'
    }
  })) : null);
}
Object.assign(__ds_scope, { Tooltip });
})(); } catch (e) { __ds_ns.__errors.push({ path: "components/feedback/Tooltip.jsx", error: String((e && e.message) || e) }); }

// components/game/ProgressBar.jsx
try { (() => {
function ProgressBar({
  value = 0,
  max = 100,
  color = 'leaf',
  label,
  showValue = true,
  height = 28,
  style
}) {
  const palettes = {
    leaf: {
      fill: 'var(--leaf-600)',
      track: 'var(--sage-100)'
    },
    coral: {
      fill: 'var(--coral-500)',
      track: 'var(--rose-100)'
    },
    gold: {
      fill: 'var(--gold-500)',
      track: 'var(--gold-100)'
    }
  };
  const p = palettes[color] || palettes.leaf;
  const pct = Math.max(0, Math.min(100, value / max * 100));
  return /*#__PURE__*/React.createElement("div", {
    style: {
      fontFamily: 'var(--font-body)',
      ...style
    }
  }, label ? /*#__PURE__*/React.createElement("div", {
    style: {
      display: 'flex',
      justifyContent: 'space-between',
      alignItems: 'baseline',
      marginBottom: 6
    }
  }, /*#__PURE__*/React.createElement("span", {
    style: {
      fontSize: 'var(--text-md)',
      fontWeight: 'var(--weight-bold)',
      color: 'var(--text-body)'
    }
  }, label), showValue ? /*#__PURE__*/React.createElement("span", {
    style: {
      fontSize: 'var(--text-md)',
      fontWeight: 'var(--weight-heavy)',
      color: 'var(--text-body)',
      fontVariantNumeric: 'tabular-nums'
    }
  }, value, " / ", max) : null) : null, /*#__PURE__*/React.createElement("div", {
    role: "progressbar",
    "aria-valuenow": value,
    "aria-valuemax": max,
    style: {
      height,
      background: p.track,
      border: '2px solid var(--border-soft)',
      borderRadius: 'var(--radius-pill)',
      overflow: 'hidden',
      boxShadow: 'inset 0 2px 3px rgba(94,66,34,0.08)'
    }
  }, /*#__PURE__*/React.createElement("div", {
    style: {
      width: `${pct}%`,
      height: '100%',
      background: p.fill,
      borderRadius: 'var(--radius-pill)',
      transition: 'width var(--transition-soft)',
      boxShadow: 'inset 0 -4px 0 rgba(0,0,0,0.12), inset 0 3px 0 rgba(255,255,255,0.28)'
    }
  })));
}
Object.assign(__ds_scope, { ProgressBar });
})(); } catch (e) { __ds_ns.__errors.push({ path: "components/game/ProgressBar.jsx", error: String((e && e.message) || e) }); }

// components/game/ResourceChip.jsx
try { (() => {
function ResourceChip({
  icon = 'paid',
  iconColor = 'var(--gold-500)',
  value = 0,
  label,
  onAdd,
  style
}) {
  const display = typeof value === 'number' ? value.toLocaleString() : value;
  return /*#__PURE__*/React.createElement("span", {
    "aria-label": label ? `${label}: ${display}` : undefined,
    style: {
      display: 'inline-flex',
      alignItems: 'center',
      gap: 8,
      background: 'var(--white)',
      border: '2px solid var(--border-soft)',
      borderRadius: 'var(--radius-pill)',
      padding: '4px 6px 4px 6px',
      minHeight: 44,
      boxShadow: 'var(--shadow-soft)',
      fontFamily: 'var(--font-display)',
      boxSizing: 'border-box',
      ...style
    }
  }, /*#__PURE__*/React.createElement("span", {
    className: "cc-icon",
    style: {
      fontSize: 26,
      color: iconColor,
      background: 'var(--cream-100)',
      borderRadius: '50%',
      width: 36,
      height: 36,
      display: 'inline-flex',
      alignItems: 'center',
      justifyContent: 'center',
      flex: 'none'
    }
  }, icon), /*#__PURE__*/React.createElement("span", {
    style: {
      fontSize: 'var(--text-lg)',
      fontWeight: 700,
      color: 'var(--ink-900)',
      fontVariantNumeric: 'tabular-nums',
      paddingRight: onAdd ? 0 : 10
    }
  }, display), onAdd ? /*#__PURE__*/React.createElement("button", {
    "aria-label": label ? `Get more ${label}` : 'Get more',
    onClick: onAdd,
    style: {
      width: 32,
      height: 32,
      borderRadius: '50%',
      border: 'none',
      background: 'var(--leaf-600)',
      color: 'var(--white)',
      display: 'inline-flex',
      alignItems: 'center',
      justifyContent: 'center',
      cursor: 'pointer',
      boxShadow: '0 2px 0 var(--leaf-700)',
      flex: 'none'
    }
  }, /*#__PURE__*/React.createElement("span", {
    className: "cc-icon",
    style: {
      fontSize: 20,
      fontVariationSettings: "'FILL' 1, 'wght' 700"
    }
  }, "add")) : null);
}
Object.assign(__ds_scope, { ResourceChip });
})(); } catch (e) { __ds_ns.__errors.push({ path: "components/game/ResourceChip.jsx", error: String((e && e.message) || e) }); }

// components/inputs/Checkbox.jsx
try { (() => {
function Checkbox({
  label,
  checked,
  defaultChecked,
  disabled,
  onChange,
  style
}) {
  const [internal, setInternal] = React.useState(!!defaultChecked);
  const isOn = checked !== undefined ? checked : internal;
  const toggle = e => {
    if (checked === undefined) setInternal(e.target.checked);
    if (onChange) onChange(e);
  };
  return /*#__PURE__*/React.createElement("label", {
    style: {
      display: 'inline-flex',
      alignItems: 'center',
      gap: 12,
      minHeight: 'var(--tap-min)',
      cursor: disabled ? 'default' : 'pointer',
      opacity: disabled ? 0.45 : 1,
      fontFamily: 'var(--font-body)',
      ...style
    }
  }, /*#__PURE__*/React.createElement("input", {
    type: "checkbox",
    checked: isOn,
    disabled: disabled,
    onChange: toggle,
    style: {
      position: 'absolute',
      opacity: 0,
      width: 32,
      height: 32
    }
  }), /*#__PURE__*/React.createElement("span", {
    "aria-hidden": "true",
    style: {
      width: 32,
      height: 32,
      borderRadius: 'var(--radius-sm)',
      border: `3px solid ${isOn ? 'var(--leaf-600)' : 'var(--border-strong)'}`,
      background: isOn ? 'var(--leaf-600)' : 'var(--white)',
      display: 'inline-flex',
      alignItems: 'center',
      justifyContent: 'center',
      flex: 'none',
      transition: 'background var(--transition-quick), border-color var(--transition-quick)'
    }
  }, isOn ? /*#__PURE__*/React.createElement("span", {
    className: "cc-icon",
    style: {
      color: 'var(--white)',
      fontSize: 22,
      fontVariationSettings: "'FILL' 1, 'wght' 700"
    }
  }, "check") : null), label ? /*#__PURE__*/React.createElement("span", {
    style: {
      fontSize: 'var(--text-md)',
      fontWeight: 'var(--weight-semibold)',
      color: 'var(--text-body)'
    }
  }, label) : null);
}
Object.assign(__ds_scope, { Checkbox });
})(); } catch (e) { __ds_ns.__errors.push({ path: "components/inputs/Checkbox.jsx", error: String((e && e.message) || e) }); }

// components/inputs/Input.jsx
try { (() => {
function Input({
  label,
  hint,
  value,
  defaultValue,
  placeholder,
  type = 'text',
  error,
  disabled,
  onChange,
  style
}) {
  const id = React.useId();
  return /*#__PURE__*/React.createElement("label", {
    htmlFor: id,
    style: {
      display: 'flex',
      flexDirection: 'column',
      gap: 8,
      fontFamily: 'var(--font-body)',
      ...style
    }
  }, label ? /*#__PURE__*/React.createElement("span", {
    style: {
      fontSize: 'var(--text-md)',
      fontWeight: 'var(--weight-bold)',
      color: 'var(--text-body)'
    }
  }, label) : null, /*#__PURE__*/React.createElement("input", {
    id: id,
    type: type,
    value: value,
    defaultValue: defaultValue,
    placeholder: placeholder,
    disabled: disabled,
    onChange: onChange,
    style: {
      fontFamily: 'var(--font-body)',
      fontSize: 'var(--text-md)',
      fontWeight: 'var(--weight-body)',
      color: 'var(--text-body)',
      background: disabled ? 'var(--surface-raised)' : 'var(--white)',
      border: `3px solid ${error ? 'var(--danger)' : 'var(--border-soft)'}`,
      borderRadius: 'var(--radius-md)',
      height: 'var(--tap-comfy)',
      padding: '0 16px',
      outline: 'none',
      boxShadow: 'inset 0 2px 3px rgba(94,66,34,0.06)',
      boxSizing: 'border-box',
      width: '100%'
    },
    onFocus: e => {
      e.target.style.borderColor = 'var(--gold-600)';
    },
    onBlur: e => {
      e.target.style.borderColor = error ? 'var(--danger)' : 'var(--border-soft)';
    }
  }), error || hint ? /*#__PURE__*/React.createElement("span", {
    style: {
      fontSize: 'var(--text-sm)',
      fontWeight: 'var(--weight-semibold)',
      color: error ? 'var(--danger)' : 'var(--text-secondary)'
    }
  }, error || hint) : null);
}
Object.assign(__ds_scope, { Input });
})(); } catch (e) { __ds_ns.__errors.push({ path: "components/inputs/Input.jsx", error: String((e && e.message) || e) }); }

// components/inputs/Radio.jsx
try { (() => {
function Radio({
  name,
  options = [],
  value,
  defaultValue,
  disabled,
  onChange,
  style
}) {
  const [internal, setInternal] = React.useState(defaultValue);
  const current = value !== undefined ? value : internal;
  const pick = v => {
    if (value === undefined) setInternal(v);
    if (onChange) onChange(v);
  };
  return /*#__PURE__*/React.createElement("div", {
    role: "radiogroup",
    style: {
      display: 'flex',
      flexDirection: 'column',
      gap: 4,
      ...style
    }
  }, options.map(o => {
    const opt = typeof o === 'string' ? {
      value: o,
      label: o
    } : o;
    const isOn = current === opt.value;
    return /*#__PURE__*/React.createElement("label", {
      key: opt.value,
      style: {
        display: 'inline-flex',
        alignItems: 'center',
        gap: 12,
        minHeight: 'var(--tap-min)',
        cursor: disabled ? 'default' : 'pointer',
        opacity: disabled ? 0.45 : 1,
        fontFamily: 'var(--font-body)'
      }
    }, /*#__PURE__*/React.createElement("input", {
      type: "radio",
      name: name,
      checked: isOn,
      disabled: disabled,
      onChange: () => pick(opt.value),
      style: {
        position: 'absolute',
        opacity: 0,
        width: 32,
        height: 32
      }
    }), /*#__PURE__*/React.createElement("span", {
      "aria-hidden": "true",
      style: {
        width: 32,
        height: 32,
        borderRadius: 'var(--radius-pill)',
        border: `3px solid ${isOn ? 'var(--leaf-600)' : 'var(--border-strong)'}`,
        background: 'var(--white)',
        display: 'inline-flex',
        alignItems: 'center',
        justifyContent: 'center',
        flex: 'none',
        transition: 'border-color var(--transition-quick)'
      }
    }, /*#__PURE__*/React.createElement("span", {
      style: {
        width: 16,
        height: 16,
        borderRadius: '50%',
        background: isOn ? 'var(--leaf-600)' : 'transparent',
        transition: 'background var(--transition-quick)'
      }
    })), /*#__PURE__*/React.createElement("span", {
      style: {
        fontSize: 'var(--text-md)',
        fontWeight: 'var(--weight-semibold)',
        color: 'var(--text-body)'
      }
    }, opt.label));
  }));
}
Object.assign(__ds_scope, { Radio });
})(); } catch (e) { __ds_ns.__errors.push({ path: "components/inputs/Radio.jsx", error: String((e && e.message) || e) }); }

// components/inputs/Select.jsx
try { (() => {
function Select({
  label,
  options = [],
  value,
  defaultValue,
  disabled,
  onChange,
  style
}) {
  const id = React.useId();
  return /*#__PURE__*/React.createElement("label", {
    htmlFor: id,
    style: {
      display: 'flex',
      flexDirection: 'column',
      gap: 8,
      fontFamily: 'var(--font-body)',
      position: 'relative',
      ...style
    }
  }, label ? /*#__PURE__*/React.createElement("span", {
    style: {
      fontSize: 'var(--text-md)',
      fontWeight: 'var(--weight-bold)',
      color: 'var(--text-body)'
    }
  }, label) : null, /*#__PURE__*/React.createElement("span", {
    style: {
      position: 'relative',
      display: 'block'
    }
  }, /*#__PURE__*/React.createElement("select", {
    id: id,
    value: value,
    defaultValue: defaultValue,
    disabled: disabled,
    onChange: onChange,
    style: {
      fontFamily: 'var(--font-body)',
      fontSize: 'var(--text-md)',
      fontWeight: 'var(--weight-semibold)',
      color: 'var(--text-body)',
      background: disabled ? 'var(--surface-raised)' : 'var(--white)',
      border: '3px solid var(--border-soft)',
      borderRadius: 'var(--radius-md)',
      height: 'var(--tap-comfy)',
      padding: '0 48px 0 16px',
      appearance: 'none',
      WebkitAppearance: 'none',
      width: '100%',
      cursor: disabled ? 'default' : 'pointer',
      boxSizing: 'border-box'
    }
  }, options.map(o => {
    const opt = typeof o === 'string' ? {
      value: o,
      label: o
    } : o;
    return /*#__PURE__*/React.createElement("option", {
      key: opt.value,
      value: opt.value
    }, opt.label);
  })), /*#__PURE__*/React.createElement("span", {
    className: "cc-icon",
    style: {
      position: 'absolute',
      right: 14,
      top: '50%',
      transform: 'translateY(-50%)',
      pointerEvents: 'none',
      color: 'var(--ink-500)'
    }
  }, "expand_more")));
}
Object.assign(__ds_scope, { Select });
})(); } catch (e) { __ds_ns.__errors.push({ path: "components/inputs/Select.jsx", error: String((e && e.message) || e) }); }

// components/inputs/Switch.jsx
try { (() => {
function Switch({
  label,
  checked,
  defaultChecked,
  disabled,
  onChange,
  style
}) {
  const [internal, setInternal] = React.useState(!!defaultChecked);
  const isOn = checked !== undefined ? checked : internal;
  const toggle = () => {
    if (disabled) return;
    if (checked === undefined) setInternal(!isOn);
    if (onChange) onChange(!isOn);
  };
  return /*#__PURE__*/React.createElement("label", {
    style: {
      display: 'inline-flex',
      alignItems: 'center',
      gap: 12,
      minHeight: 'var(--tap-min)',
      cursor: disabled ? 'default' : 'pointer',
      opacity: disabled ? 0.45 : 1,
      fontFamily: 'var(--font-body)',
      ...style
    }
  }, /*#__PURE__*/React.createElement("button", {
    role: "switch",
    "aria-checked": isOn,
    "aria-label": label,
    disabled: disabled,
    onClick: toggle,
    style: {
      width: 68,
      height: 40,
      borderRadius: 'var(--radius-pill)',
      border: 'none',
      padding: 4,
      background: isOn ? 'var(--leaf-600)' : 'var(--ink-300)',
      display: 'inline-flex',
      justifyContent: isOn ? 'flex-end' : 'flex-start',
      cursor: 'inherit',
      transition: 'background var(--transition-quick)',
      boxShadow: 'inset 0 2px 3px rgba(62,49,38,0.18)',
      flex: 'none'
    }
  }, /*#__PURE__*/React.createElement("span", {
    style: {
      width: 32,
      height: 32,
      borderRadius: '50%',
      background: 'var(--white)',
      boxShadow: 'var(--shadow-soft)',
      transition: 'transform var(--transition-soft)'
    }
  })), label ? /*#__PURE__*/React.createElement("span", {
    style: {
      fontSize: 'var(--text-md)',
      fontWeight: 'var(--weight-semibold)',
      color: 'var(--text-body)'
    }
  }, label) : null);
}
Object.assign(__ds_scope, { Switch });
})(); } catch (e) { __ds_ns.__errors.push({ path: "components/inputs/Switch.jsx", error: String((e && e.message) || e) }); }

// components/navigation/Tabs.jsx
try { (() => {
function Tabs({
  tabs = [],
  value,
  defaultValue,
  onChange,
  style
}) {
  const norm = tabs.map(t => typeof t === 'string' ? {
    value: t,
    label: t
  } : t);
  const [internal, setInternal] = React.useState(defaultValue ?? (norm[0] && norm[0].value));
  const current = value !== undefined ? value : internal;
  const pick = v => {
    if (value === undefined) setInternal(v);
    if (onChange) onChange(v);
  };
  return /*#__PURE__*/React.createElement("div", {
    role: "tablist",
    style: {
      display: 'inline-flex',
      gap: 4,
      background: 'var(--cream-100)',
      border: '2px solid var(--border-soft)',
      borderRadius: 'var(--radius-pill)',
      padding: 4,
      ...style
    }
  }, norm.map(t => {
    const active = current === t.value;
    return /*#__PURE__*/React.createElement("button", {
      key: t.value,
      role: "tab",
      "aria-selected": active,
      onClick: () => pick(t.value),
      style: {
        fontFamily: 'var(--font-display)',
        fontSize: 'var(--text-md)',
        fontWeight: 700,
        color: active ? 'var(--white)' : 'var(--ink-700)',
        background: active ? 'var(--coral-500)' : 'transparent',
        border: 'none',
        borderRadius: 'var(--radius-pill)',
        minHeight: 'var(--tap-min)',
        padding: '0 22px',
        cursor: 'pointer',
        display: 'inline-flex',
        alignItems: 'center',
        gap: 8,
        boxShadow: active ? '0 2px 0 var(--coral-700)' : 'none',
        transition: 'background var(--transition-quick), color var(--transition-quick)'
      }
    }, t.icon ? /*#__PURE__*/React.createElement("span", {
      className: "cc-icon",
      style: {
        fontSize: 22
      }
    }, t.icon) : null, t.label);
  }));
}
Object.assign(__ds_scope, { Tabs });
})(); } catch (e) { __ds_ns.__errors.push({ path: "components/navigation/Tabs.jsx", error: String((e && e.message) || e) }); }

// ui_kits/merge-game/App.jsx
try { (() => {
const {
  Dialog,
  Button,
  IconButton,
  ProgressBar
} = window.CozyCottageDesignSystem_d8a5c0;
function NavItem({
  icon,
  label,
  active,
  onTap
}) {
  return /*#__PURE__*/React.createElement("button", {
    onClick: onTap,
    "aria-label": label,
    style: {
      flex: 1,
      minHeight: 64,
      border: 'none',
      cursor: 'pointer',
      background: 'transparent',
      display: 'flex',
      flexDirection: 'column',
      alignItems: 'center',
      justifyContent: 'center',
      gap: 2,
      color: active ? 'var(--coral-600)' : 'var(--ink-500)'
    }
  }, /*#__PURE__*/React.createElement("span", {
    className: "cc-icon",
    style: {
      fontSize: 30
    }
  }, icon), /*#__PURE__*/React.createElement("span", {
    style: {
      fontFamily: 'var(--font-body)',
      fontSize: 15,
      fontWeight: 800
    }
  }, label));
}
function App() {
  const [screen, setScreen] = React.useState('garden');
  const [coins, setCoins] = React.useState(1250);
  const [gems] = React.useState(46);
  const [energy, setEnergy] = React.useState(24);
  const [taskProgress, setTaskProgress] = React.useState(0);
  const [taskDone, setTaskDone] = React.useState(false);
  const [reward, setReward] = React.useState(false);
  return /*#__PURE__*/React.createElement("div", {
    style: {
      width: '100%',
      maxWidth: 430,
      margin: '0 auto',
      height: '100dvh',
      display: 'flex',
      flexDirection: 'column',
      position: 'relative',
      background: 'var(--surface-page)',
      overflow: 'hidden'
    },
    "data-screen-label": `Merge Game — ${screen}`
  }, /*#__PURE__*/React.createElement("div", {
    style: {
      flex: 1,
      overflowY: 'auto',
      paddingBottom: 12
    }
  }, screen === 'garden' ? /*#__PURE__*/React.createElement(GardenScreen, {
    coins: coins,
    gems: gems,
    energy: energy,
    onSpendEnergy: () => setEnergy(e => Math.max(0, e - 1)),
    onEarn: n => setCoins(c => c + n),
    taskDone: taskDone,
    taskProgress: taskProgress,
    onTaskProgress: setTaskProgress,
    onOpenReward: () => setReward(true)
  }) : null, screen === 'story' ? /*#__PURE__*/React.createElement(StoryScreen, null) : null, screen === 'settings' ? /*#__PURE__*/React.createElement(SettingsScreen, null) : null), /*#__PURE__*/React.createElement("nav", {
    style: {
      display: 'flex',
      gap: 4,
      padding: '6px 10px calc(6px + env(safe-area-inset-bottom))',
      background: 'var(--white)',
      borderTop: '2px solid var(--border-soft)',
      boxShadow: '0 -4px 12px rgba(94,66,34,0.08)',
      flex: 'none'
    }
  }, /*#__PURE__*/React.createElement(NavItem, {
    icon: "yard",
    label: "Garden",
    active: screen === 'garden',
    onTap: () => setScreen('garden')
  }), /*#__PURE__*/React.createElement(NavItem, {
    icon: "menu_book",
    label: "Story",
    active: screen === 'story',
    onTap: () => setScreen('story')
  }), /*#__PURE__*/React.createElement(NavItem, {
    icon: "settings",
    label: "Settings",
    active: screen === 'settings',
    onTap: () => setScreen('settings')
  })), reward ? /*#__PURE__*/React.createElement(Dialog, {
    title: "Task Complete!",
    tone: "reward",
    onClose: () => {
      setReward(false);
      setTaskDone(true);
    },
    actions: /*#__PURE__*/React.createElement(Button, {
      color: "gold",
      icon: "star",
      fullWidth: true,
      onClick: () => {
        setReward(false);
        setTaskDone(true);
        setCoins(c => c + 250);
      }
    }, "Claim 250 Coins")
  }, /*#__PURE__*/React.createElement("div", {
    style: {
      display: 'flex',
      flexDirection: 'column',
      gap: 14,
      alignItems: 'center'
    }
  }, /*#__PURE__*/React.createElement("span", {
    className: "cc-icon",
    style: {
      fontSize: 64,
      color: 'var(--gold-500)'
    }
  }, "emoji_events"), /*#__PURE__*/React.createElement("span", null, "Marvelous, dear! You merged 3 times today."), /*#__PURE__*/React.createElement(ProgressBar, {
    value: 3,
    max: 3,
    color: "gold",
    style: {
      width: '100%'
    }
  }))) : null);
}
ReactDOM.createRoot(document.getElementById('root')).render(/*#__PURE__*/React.createElement(App, null));
})(); } catch (e) { __ds_ns.__errors.push({ path: "ui_kits/merge-game/App.jsx", error: String((e && e.message) || e) }); }

// ui_kits/merge-game/GardenScreen.jsx
try { (() => {
const {
  Card,
  Badge,
  Tag,
  Button,
  ProgressBar,
  ResourceChip,
  Toast
} = window.CozyCottageDesignSystem_d8a5c0;
const MERGE_TYPES = {
  flower: {
    icon: 'local_florist',
    tint: 'var(--rose-100)',
    color: 'var(--coral-500)'
  },
  plant: {
    icon: 'potted_plant',
    tint: 'var(--sage-100)',
    color: 'var(--leaf-600)'
  },
  bake: {
    icon: 'cake',
    tint: 'var(--gold-100)',
    color: 'var(--gold-600)'
  },
  tea: {
    icon: 'emoji_food_beverage',
    tint: 'var(--lavender-100)',
    color: 'var(--lavender-700)'
  }
};
function MergeTile({
  item,
  selected,
  onTap
}) {
  if (!item) {
    return /*#__PURE__*/React.createElement("div", {
      style: {
        aspectRatio: '1',
        borderRadius: 'var(--radius-md)',
        background: 'rgba(255,255,255,0.5)',
        border: '2px dashed var(--border-soft)'
      }
    });
  }
  const t = MERGE_TYPES[item.type];
  return /*#__PURE__*/React.createElement("button", {
    onClick: onTap,
    "aria-label": `${item.type} level ${item.level}`,
    style: {
      aspectRatio: '1',
      borderRadius: 'var(--radius-md)',
      border: selected ? '3px solid var(--gold-600)' : '2px solid var(--border-soft)',
      background: t.tint,
      cursor: 'pointer',
      position: 'relative',
      display: 'flex',
      alignItems: 'center',
      justifyContent: 'center',
      boxShadow: selected ? '0 0 0 3px var(--gold-300), var(--shadow-soft)' : 'var(--shadow-soft)',
      transform: selected ? 'scale(1.06)' : 'scale(1)',
      transition: 'transform var(--transition-soft), box-shadow var(--transition-quick)',
      padding: 0
    }
  }, /*#__PURE__*/React.createElement("span", {
    className: "cc-icon",
    style: {
      fontSize: 34,
      color: t.color
    }
  }, t.icon), /*#__PURE__*/React.createElement("span", {
    style: {
      position: 'absolute',
      bottom: 4,
      right: 4,
      fontFamily: 'var(--font-display)',
      fontWeight: 800,
      fontSize: 15,
      background: 'var(--white)',
      color: 'var(--ink-900)',
      borderRadius: 'var(--radius-pill)',
      padding: '0 7px',
      lineHeight: '20px',
      boxShadow: 'var(--shadow-soft)'
    }
  }, item.level));
}
function GardenScreen({
  coins,
  gems,
  energy,
  onSpendEnergy,
  onEarn,
  taskDone,
  taskProgress,
  onTaskProgress,
  onOpenReward
}) {
  const [board, setBoard] = React.useState(() => [{
    id: 1,
    type: 'flower',
    level: 1
  }, {
    id: 2,
    type: 'plant',
    level: 2
  }, {
    id: 3,
    type: 'flower',
    level: 1
  }, {
    id: 4,
    type: 'bake',
    level: 1
  }, {
    id: 5,
    type: 'tea',
    level: 1
  }, {
    id: 6,
    type: 'bake',
    level: 1
  }, {
    id: 7,
    type: 'plant',
    level: 2
  }, null, {
    id: 9,
    type: 'flower',
    level: 2
  }, null, {
    id: 11,
    type: 'tea',
    level: 1
  }, {
    id: 12,
    type: 'plant',
    level: 1
  }, {
    id: 13,
    type: 'bake',
    level: 2
  }, {
    id: 14,
    type: 'flower',
    level: 2
  }, null, {
    id: 16,
    type: 'plant',
    level: 1
  }, {
    id: 17,
    type: 'tea',
    level: 2
  }, {
    id: 18,
    type: 'bake',
    level: 2
  }, {
    id: 19,
    type: 'flower',
    level: 3
  }, {
    id: 20,
    type: 'tea',
    level: 2
  }]);
  const [sel, setSel] = React.useState(null);
  const [toast, setToast] = React.useState(null);
  const toastTimer = React.useRef(null);
  const say = (msg, icon, color) => {
    setToast({
      msg,
      icon,
      color
    });
    clearTimeout(toastTimer.current);
    toastTimer.current = setTimeout(() => setToast(null), 2200);
  };
  const tap = i => {
    const item = board[i];
    if (!item) {
      setSel(null);
      return;
    }
    if (sel === null || sel === i) {
      setSel(sel === i ? null : i);
      return;
    }
    const other = board[sel];
    if (other && other.type === item.type && other.level === item.level) {
      if (energy <= 0) {
        say('Out of energy — rest a moment, dear', 'bolt', 'coral');
        setSel(null);
        return;
      }
      const next = board.slice();
      next[sel] = null;
      next[i] = {
        ...item,
        level: item.level + 1
      };
      setBoard(next);
      setSel(null);
      onSpendEnergy();
      onEarn(item.level * 10);
      say(`Lovely! +${item.level * 10} coins`, 'paid', 'gold');
      if (!taskDone) {
        const p = taskProgress + 1;
        onTaskProgress(p);
        if (p >= 3) setTimeout(onOpenReward, 500);
      }
    } else {
      setSel(i);
    }
  };
  return /*#__PURE__*/React.createElement("div", {
    style: {
      display: 'flex',
      flexDirection: 'column',
      gap: 16,
      padding: '16px 16px 0'
    }
  }, /*#__PURE__*/React.createElement("div", {
    style: {
      display: 'flex',
      gap: 8,
      justifyContent: 'space-between'
    }
  }, /*#__PURE__*/React.createElement(ResourceChip, {
    icon: "paid",
    label: "Coins",
    value: coins,
    onAdd: () => say('The shop opens soon!', 'storefront', 'gold')
  }), /*#__PURE__*/React.createElement(ResourceChip, {
    icon: "diamond",
    iconColor: "var(--lavender-500)",
    label: "Gems",
    value: gems
  }), /*#__PURE__*/React.createElement(ResourceChip, {
    icon: "bolt",
    iconColor: "var(--coral-500)",
    label: "Energy",
    value: `${energy}`
  })), /*#__PURE__*/React.createElement(Card, {
    tone: "garden",
    padding: "14px 16px"
  }, /*#__PURE__*/React.createElement("div", {
    style: {
      display: 'flex',
      alignItems: 'center',
      gap: 10,
      marginBottom: 8
    }
  }, /*#__PURE__*/React.createElement(Badge, {
    color: "leaf",
    icon: "yard"
  }, "Daily Task"), taskDone ? /*#__PURE__*/React.createElement(Tag, {
    color: "gold",
    icon: "check"
  }, "Complete") : null), /*#__PURE__*/React.createElement(ProgressBar, {
    label: "Merge 3 times",
    value: Math.min(taskProgress, 3),
    max: 3,
    color: "leaf"
  })), /*#__PURE__*/React.createElement("div", {
    style: {
      display: 'grid',
      gridTemplateColumns: 'repeat(4, 1fr)',
      gap: 8,
      background: 'var(--butter-100)',
      border: '2px solid var(--border-soft)',
      borderRadius: 'var(--radius-lg)',
      padding: 10,
      boxShadow: 'inset 0 2px 4px rgba(94,66,34,0.08)'
    }
  }, board.map((item, i) => /*#__PURE__*/React.createElement(MergeTile, {
    key: item ? item.id : `e${i}`,
    item: item,
    selected: sel === i,
    onTap: () => tap(i)
  }))), /*#__PURE__*/React.createElement("p", {
    style: {
      margin: 0,
      textAlign: 'center',
      fontSize: 'var(--text-sm)',
      color: 'var(--text-secondary)'
    }
  }, "Tap two matching items to merge them"), toast ? /*#__PURE__*/React.createElement("div", {
    style: {
      position: 'absolute',
      bottom: 108,
      left: 0,
      right: 0,
      display: 'flex',
      justifyContent: 'center',
      pointerEvents: 'none'
    }
  }, /*#__PURE__*/React.createElement(Toast, {
    icon: toast.icon,
    color: toast.color
  }, toast.msg)) : null);
}
window.GardenScreen = GardenScreen;
})(); } catch (e) { __ds_ns.__errors.push({ path: "ui_kits/merge-game/GardenScreen.jsx", error: String((e && e.message) || e) }); }

// ui_kits/merge-game/SettingsScreen.jsx
try { (() => {
const {
  Card,
  Switch,
  Radio,
  Select,
  Button
} = window.CozyCottageDesignSystem_d8a5c0;
function SettingsScreen() {
  return /*#__PURE__*/React.createElement("div", {
    style: {
      display: 'flex',
      flexDirection: 'column',
      gap: 16,
      padding: '16px 16px 0'
    }
  }, /*#__PURE__*/React.createElement("h2", {
    style: {
      fontSize: 'var(--text-2xl)'
    }
  }, "Settings"), /*#__PURE__*/React.createElement(Card, {
    padding: "16px 18px"
  }, /*#__PURE__*/React.createElement("h3", {
    style: {
      fontSize: 'var(--text-lg)',
      marginBottom: 10
    }
  }, "Sound"), /*#__PURE__*/React.createElement("div", {
    style: {
      display: 'flex',
      flexDirection: 'column',
      gap: 4
    }
  }, /*#__PURE__*/React.createElement(Switch, {
    label: "Music",
    defaultChecked: true
  }), /*#__PURE__*/React.createElement(Switch, {
    label: "Sound effects",
    defaultChecked: true
  }))), /*#__PURE__*/React.createElement(Card, {
    tone: "butter",
    padding: "16px 18px"
  }, /*#__PURE__*/React.createElement("h3", {
    style: {
      fontSize: 'var(--text-lg)',
      marginBottom: 10
    }
  }, "Reading comfort"), /*#__PURE__*/React.createElement("div", {
    style: {
      display: 'flex',
      flexDirection: 'column',
      gap: 12
    }
  }, /*#__PURE__*/React.createElement(Select, {
    label: "Text size",
    options: ['Large', 'Extra large'],
    defaultValue: "Large"
  }), /*#__PURE__*/React.createElement(Radio, {
    name: "pace",
    options: ['Relaxed story pace', 'Regular story pace'],
    defaultValue: "Relaxed story pace"
  }))), /*#__PURE__*/React.createElement(Button, {
    color: "cream",
    icon: "help",
    fullWidth: true
  }, "Help & Support"));
}
window.SettingsScreen = SettingsScreen;
})(); } catch (e) { __ds_ns.__errors.push({ path: "ui_kits/merge-game/SettingsScreen.jsx", error: String((e && e.message) || e) }); }

// ui_kits/merge-game/StoryScreen.jsx
try { (() => {
const {
  Card,
  Badge,
  Button,
  Tag
} = window.CozyCottageDesignSystem_d8a5c0;
const STORY_BEATS = [{
  speaker: 'Evelyn',
  text: 'The key still fits. After thirty years… Aunt Rose\u2019s cottage is finally mine.',
  choices: null
}, {
  speaker: 'Marta (neighbor)',
  text: 'Evelyn? My goodness, is that you? You know, your aunt left something for you in the greenhouse.',
  choices: null
}, {
  speaker: 'Evelyn',
  text: 'A letter, sealed with a pressed daisy. Do I open it now, or wait until the garden is tidy?',
  choices: ['Open it now', 'The garden first']
}];
function Portrait({
  name
}) {
  return /*#__PURE__*/React.createElement("div", {
    style: {
      width: 84,
      height: 84,
      borderRadius: '50%',
      flex: 'none',
      background: 'var(--lavender-100)',
      border: '3px solid var(--white)',
      boxShadow: 'var(--shadow-card)',
      display: 'flex',
      alignItems: 'center',
      justifyContent: 'center',
      fontFamily: 'var(--font-display)',
      fontWeight: 800,
      fontSize: 30,
      color: 'var(--lavender-700)'
    },
    title: `${name} — illustration placeholder`
  }, name.charAt(0));
}
function StoryScreen() {
  const [beat, setBeat] = React.useState(0);
  const [picked, setPicked] = React.useState(null);
  const b = STORY_BEATS[beat];
  const advance = () => {
    if (beat < STORY_BEATS.length - 1) {
      setBeat(beat + 1);
      setPicked(null);
    }
  };
  return /*#__PURE__*/React.createElement("div", {
    style: {
      display: 'flex',
      flexDirection: 'column',
      gap: 16,
      padding: '16px 16px 0',
      height: '100%',
      boxSizing: 'border-box'
    }
  }, /*#__PURE__*/React.createElement("div", {
    style: {
      display: 'flex',
      alignItems: 'center',
      justifyContent: 'space-between'
    }
  }, /*#__PURE__*/React.createElement(Badge, {
    color: "coral",
    icon: "menu_book"
  }, "Chapter 1"), /*#__PURE__*/React.createElement(Tag, {
    color: "rose"
  }, "The Daisy Letter")), /*#__PURE__*/React.createElement("div", {
    style: {
      flex: 1,
      borderRadius: 'var(--radius-lg)',
      border: '2px solid var(--border-soft)',
      background: 'linear-gradient(180deg, var(--lavender-100) 0%, var(--rose-100) 55%, var(--sage-100) 100%)',
      display: 'flex',
      alignItems: 'center',
      justifyContent: 'center',
      minHeight: 180
    }
  }, /*#__PURE__*/React.createElement("span", {
    style: {
      fontSize: 'var(--text-sm)',
      fontWeight: 700,
      color: 'var(--text-muted)',
      background: 'rgba(255,255,255,0.7)',
      padding: '6px 14px',
      borderRadius: 'var(--radius-pill)'
    }
  }, "Scene illustration placeholder")), /*#__PURE__*/React.createElement(Card, {
    tone: "story",
    padding: "16px 18px"
  }, /*#__PURE__*/React.createElement("div", {
    style: {
      display: 'flex',
      gap: 14,
      alignItems: 'flex-start'
    }
  }, /*#__PURE__*/React.createElement(Portrait, {
    name: b.speaker
  }), /*#__PURE__*/React.createElement("div", {
    style: {
      flex: 1
    }
  }, /*#__PURE__*/React.createElement("h3", {
    style: {
      fontSize: 'var(--text-lg)',
      marginBottom: 4
    }
  }, b.speaker), /*#__PURE__*/React.createElement("p", {
    style: {
      margin: 0
    }
  }, b.text))), /*#__PURE__*/React.createElement("div", {
    style: {
      display: 'flex',
      flexDirection: 'column',
      gap: 10,
      marginTop: 14
    }
  }, b.choices ? picked === null ? b.choices.map(c => /*#__PURE__*/React.createElement(Button, {
    key: c,
    color: c === b.choices[0] ? 'coral' : 'cream',
    fullWidth: true,
    onClick: () => setPicked(c)
  }, c)) : /*#__PURE__*/React.createElement("p", {
    style: {
      margin: 0,
      fontWeight: 800,
      color: 'var(--coral-700)'
    }
  }, "\u201C", picked, ".\u201D \u2014 To be continued\u2026") : /*#__PURE__*/React.createElement(Button, {
    color: "coral",
    icon: "arrow_forward",
    fullWidth: true,
    onClick: advance
  }, "Continue"))));
}
window.StoryScreen = StoryScreen;
})(); } catch (e) { __ds_ns.__errors.push({ path: "ui_kits/merge-game/StoryScreen.jsx", error: String((e && e.message) || e) }); }

__ds_ns.Button = __ds_scope.Button;

__ds_ns.IconButton = __ds_scope.IconButton;

__ds_ns.Badge = __ds_scope.Badge;

__ds_ns.Card = __ds_scope.Card;

__ds_ns.Tag = __ds_scope.Tag;

__ds_ns.Dialog = __ds_scope.Dialog;

__ds_ns.Toast = __ds_scope.Toast;

__ds_ns.Tooltip = __ds_scope.Tooltip;

__ds_ns.ProgressBar = __ds_scope.ProgressBar;

__ds_ns.ResourceChip = __ds_scope.ResourceChip;

__ds_ns.Checkbox = __ds_scope.Checkbox;

__ds_ns.Input = __ds_scope.Input;

__ds_ns.Radio = __ds_scope.Radio;

__ds_ns.Select = __ds_scope.Select;

__ds_ns.Switch = __ds_scope.Switch;

__ds_ns.Tabs = __ds_scope.Tabs;

})();
