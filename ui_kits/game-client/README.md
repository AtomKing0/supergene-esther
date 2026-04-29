# Game Client UI Kit

Interactive recreation of the six core screens from **Solitaire City Journey**, built as a mobile-portrait prototype (360×780). Uses real lifted assets and the shared design tokens in `../../colors_and_type.css`.

## Screens

1. **Splash / Lobby** — city painting background, HUD, side rail, Play CTA, idle-gold overlay
2. **Pre-level popup** — bet x1/x2/x4 selection with live entry/reward math
3. **In-game** — tripeaks layout, open card, draw deck, streak, boosters, ±1 match interaction
4. **Result (Clear)** — stars burst, count-up gold/hammer
5. **Result (Fail)** — "So close!" retry
6. **City Decorate** — 5 building slots × 2 upgrade stages

## Files

- `index.html` — single-page interactive prototype. Open this.
- `components/Screen.jsx` — phone frame + screen transitions
- `components/Button.jsx` — stamped primary/secondary/confirm buttons
- `components/CurrencyPill.jsx` — HUD coin/hammer pills
- `components/PlayingCard.jsx` — red/black cards + back variants
- `components/Popup.jsx` — paper popup with ribbon title
- `components/LobbyScreen.jsx`
- `components/PreLevelPopup.jsx`
- `components/IngameScreen.jsx`
- `components/ResultScreen.jsx`
- `components/CityDecorateScreen.jsx`

## Interactivity

- Play button → pre-level popup → in-game
- Tap card ±1 from open card → removes; otherwise shakes
- Draw deck tap → new open card
- Clear all field → result (clear)
- Result → back to lobby; hammer count increments
- City decorate spends hammers on building upgrades

## Caveats

Card-matching logic is minimal; the real game has suit pairs, wild cards, streak multipliers, DDA. This kit is cosmetic + flow-verification only.
