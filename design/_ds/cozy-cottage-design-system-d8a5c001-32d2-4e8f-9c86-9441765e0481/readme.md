# Cozy Cottage Design System

Casual merge-game design system: a sunlit country garden and a snug cottage, with a little human drama. Warm, kind, and cheerful with a soft dramatic flair — hand-crafted coziness, never cold minimalism.

**Audience:** North American women 55+. Every decision defers to readability and comfort: 18px+ body text, weight 600 minimum, WCAG AA contrast, 48px+ touch targets, generous whitespace, labels on every icon, big clear reward numbers.

**Sources:** built from a written brand brief only (see project chat). No codebase, Figma, logo, fonts, or illustration assets were provided.

---

## CONTENT FUNDAMENTALS

- **Voice:** a warm, slightly theatrical neighbor. Second person, addressed directly and affectionately ("you", occasionally "dear"). Never corporate, never slangy/hip, never childish.
- **Everyday copy:** short, kind, concrete. *"Good morning, dear. The roses could use a little water."*
- **Story copy:** gentle drama with ellipses and reveals. *"She never mailed the letter… until today."*
- **Reward copy:** celebratory and exclamatory. *"Marvelous! You earned 250 coins!"* Numbers are always large and explicit.
- **Casing:** Title Case for headings/buttons ("Play Chapter", "Claim Reward"); sentence case for body and hints.
- **Emoji:** not used. Warmth comes from words, color, and icon stickers.
- **Buttons:** verb-first, 1–3 words ("Plant", "Claim Reward", "Open it now").
- **Errors/empty states:** reassuring, never blaming. *"Out of energy — rest a moment, dear."*

## VISUAL FOUNDATIONS

- **Color:** warm cream/butter pages (`--cream-50`, never stark white pages); white reserved for cards. Accents: coral/rose (story, warmth, primary actions), sage/leaf (garden, success), lavender (floral sub-accent), warm gold (rewards, premium). Pastels for fills only; the 600/700 steps carry text and edges so contrast holds AA. Text is warm brown ink (`--ink-900/700`) — never gray-on-gray, never cold black.
- **Type:** Baloo 2 (display; 700–800) for headings, buttons, big numbers; Nunito (body; 600–900) for everything else. 18px base, 16px floor, 1.6 body line-height, no weight below 600, no thin/light ever. Decorative type: none by default — if a flourish is needed it belongs only in story/chapter titles.
- **Spacing:** 4px grid (`--space-1..8`), generous by default; screens breathe, never crowded.
- **Corners:** everything soft — 10/16/24/32px + pill. Buttons are always pills.
- **Shadows:** warm brown, never gray/black (`--shadow-soft/card/float`). Buttons use a solid darker bottom edge (`0 4px 0 <edge>`), the "sticker" ledge.
- **Sticker language:** cut-out white rings (`--sticker-ring`) on badges, dialogs, and pop-out moments make elements feel like stickers on a scrapbook page.
- **Backgrounds:** flat warm tints or very soft vertical gradients between neighboring pastels (e.g. lavender → rose → sage for story scenes). No patterns, no photography, no dark mode.
- **Animation:** small and tactile. Press = 3px downward travel with edge compression (120ms ease-out); appear/expand = 220ms with gentle overshoot (`--transition-soft`). No parallax, no infinite loops; reward moments may pop/scale once, festively.
- **Hover:** slight brighten (`filter: brightness(1.06)`) on filled controls; underlined coral links darken.
- **Press:** translateY(3px) + edge compresses from 4px to 1px — physical, satisfying.
- **Borders:** 2px soft cream-tan (`--border-soft`) on cards and tracks; 3px on inputs and selected states.
- **Focus:** 3px gold outline, 2px offset — visible on every interactive element.
- **Cards:** white or tonal (butter/story/garden/reward), 24px radius, 2px soft border, warm card shadow.
- **Transparency/blur:** none. Scrims are warm brown at 45% (`rgba(62,49,38,0.45)`).
- **Imagery:** warm cartoon (semi-real) illustration, expressive adult heroine, cottage/garden/baking/merge items, cozy natural light. **No illustration assets exist yet — use clearly-labeled placeholders, never generated or hand-drawn SVG art.**

## ICONOGRAPHY

- **No brand icon set or logo was provided.** Wherever a logo would go, set "Cozy Cottage" in Baloo 2 — do not draw a mark.
- **Substitute icon set:** [Material Symbols Rounded](https://fonts.google.com/icons) (filled, weight 500) from the Google Fonts CDN — chosen for its soft, rounded, sticker-like shapes. Loaded in `tokens/fonts.css`; use via `<span class="cc-icon">yard</span>`.
- **Rules:** icons are always filled (never outline), always colored from the palette, and always accompanied by a visible text label (Tooltip is supplemental only). Common glyphs: `yard` garden, `menu_book` story, `paid` coins, `diamond` gems, `bolt` energy, `cake` baking, `favorite` hearts, `star`/`emoji_events` rewards, `local_florist` flowers.
- No emoji, no unicode-as-icon.

## INDEX

- `styles.css` — global entry; `@import`s everything under `tokens/`
- `tokens/` — `colors.css`, `typography.css`, `spacing.css`, `effects.css`, `fonts.css`, `base.css`
- `guidelines/` — specimen cards (colors, type, spacing, shadows, voice, icons) shown in the Design System tab
- `components/`
  - `buttons/` — **Button** (sticker pill), **IconButton** (labeled round)
  - `inputs/` — **Input**, **Select**, **Checkbox**, **Radio**, **Switch**
  - `display/` — **Card**, **Badge**, **Tag**
  - `feedback/` — **Dialog**, **Toast**, **Tooltip**
  - `navigation/` — **Tabs**
  - `game/` — **ProgressBar**, **ResourceChip** *(intentional additions: merge-game HUD needs chunky progress and currency counters with big numerals)*
- `ui_kits/merge-game/` — interactive 390px click-through: Garden (merge board), Story, Settings + reward popup
- `SKILL.md` — agent-facing usage guide

## CAVEATS

- **Fonts are Google-Fonts substitutes** (Baloo 2 + Nunito via CDN, no binaries shipped). Provide real brand fonts to replace them in `tokens/fonts.css`.
- **Icons are a CDN substitute** (Material Symbols Rounded). Provide brand icons to replace.
- **No logo and no illustrations** were provided; none were invented. All art slots are labeled placeholders.
