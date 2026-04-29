// Inline SVG icon set — all icons generated, no asset dependencies.
// Exports: <Icon name="coin" size={32} />

const ICONS = {
  coin: (
    <g>
      <circle cx="32" cy="32" r="28" fill="url(#coinOuter)" stroke="#7a4a0c" strokeWidth="2"/>
      <circle cx="32" cy="32" r="22" fill="url(#coinInner)" stroke="#b3740f" strokeWidth="1.5"/>
      <text x="32" y="42" fontSize="26" fontWeight="900" textAnchor="middle" fill="#7a4a0c" fontFamily="Baloo 2, sans-serif">$</text>
      <ellipse cx="24" cy="22" rx="6" ry="3" fill="rgba(255,255,255,.45)"/>
    </g>
  ),
  hammer: (
    <g>
      <rect x="14" y="10" width="36" height="22" rx="4" fill="url(#hammerHead)" stroke="#3a2312" strokeWidth="2"/>
      <rect x="18" y="14" width="4" height="14" fill="rgba(255,255,255,.25)"/>
      <rect x="28" y="30" width="8" height="26" rx="3" fill="#9a6a3a" stroke="#3a2312" strokeWidth="2"/>
      <rect x="30" y="32" width="2" height="22" fill="rgba(255,255,255,.2)"/>
    </g>
  ),
  home: (
    <g>
      <path d="M32 10 L56 32 L52 32 L52 54 L38 54 L38 40 L26 40 L26 54 L12 54 L12 32 L8 32 Z"
        fill="url(#homeFill)" stroke="#7a4a0c" strokeWidth="2" strokeLinejoin="round"/>
      <rect x="28" y="20" width="8" height="10" fill="#6a3a08"/>
    </g>
  ),
  close: (
    <g>
      <path d="M18 18 L46 46 M46 18 L18 46" stroke="#7a4a0c" strokeWidth="6" strokeLinecap="round"/>
    </g>
  ),
  setting: (
    <g>
      <path d="M32 10 L36 10 L38 18 L44 22 L50 18 L54 22 L50 28 L52 34 L60 36 L60 40 L52 42 L50 48 L54 54 L50 58 L44 54 L38 58 L36 66 L32 66 L28 58 L22 54 L16 58 L12 54 L16 48 L14 42 L6 40 L6 36 L14 34 L16 28 L12 22 L16 18 L22 22 L28 18 Z"
        fill="url(#settingFill)" stroke="#7a4a0c" strokeWidth="2" strokeLinejoin="round" transform="scale(.85) translate(5.6,4)"/>
      <circle cx="32" cy="32" r="7" fill="#fff" stroke="#7a4a0c" strokeWidth="2"/>
    </g>
  ),
  star: (
    <g>
      <path d="M32 6 L40 24 L60 27 L45 41 L49 60 L32 50 L15 60 L19 41 L4 27 L24 24 Z"
        fill="url(#starFill)" stroke="#c9891a" strokeWidth="2" strokeLinejoin="round"/>
      <path d="M32 14 L37 25 L28 24 Z" fill="rgba(255,255,255,.5)"/>
    </g>
  ),
  crown: (
    <g>
      <path d="M8 46 L12 16 L22 28 L32 10 L42 28 L52 16 L56 46 Z"
        fill="url(#crownFill)" stroke="#8a5a0c" strokeWidth="2.5" strokeLinejoin="round"/>
      <rect x="8" y="46" width="48" height="10" rx="2" fill="url(#crownBand)" stroke="#8a5a0c" strokeWidth="2.5"/>
      <circle cx="12" cy="16" r="4" fill="#ff4060" stroke="#8a5a0c" strokeWidth="1.5"/>
      <circle cx="32" cy="10" r="4" fill="#ff4060" stroke="#8a5a0c" strokeWidth="1.5"/>
      <circle cx="52" cy="16" r="4" fill="#ff4060" stroke="#8a5a0c" strokeWidth="1.5"/>
      <circle cx="20" cy="50" r="2.5" fill="#3fc0e8"/>
      <circle cx="32" cy="50" r="2.5" fill="#4fe060"/>
      <circle cx="44" cy="50" r="2.5" fill="#ff6060"/>
    </g>
  ),
  check: (
    <g>
      <circle cx="32" cy="32" r="26" fill="url(#checkFill)" stroke="#2a6020" strokeWidth="2"/>
      <path d="M18 32 L28 42 L46 22" stroke="#fff" strokeWidth="6" strokeLinecap="round" strokeLinejoin="round" fill="none"/>
    </g>
  ),
  leaderboard: (
    <g>
      <rect x="22" y="26" width="20" height="32" rx="2" fill="url(#leaderFill)" stroke="#7a4a0c" strokeWidth="2"/>
      <rect x="6" y="36" width="16" height="22" rx="2" fill="#7fb3e8" stroke="#7a4a0c" strokeWidth="2"/>
      <rect x="42" y="32" width="16" height="26" rx="2" fill="#e88c7f" stroke="#7a4a0c" strokeWidth="2"/>
      <text x="32" y="46" fontSize="12" fontWeight="900" textAnchor="middle" fill="#fff" fontFamily="Baloo 2">1</text>
      <text x="14" y="54" fontSize="10" fontWeight="900" textAnchor="middle" fill="#fff">2</text>
      <text x="50" y="50" fontSize="10" fontWeight="900" textAnchor="middle" fill="#fff">3</text>
    </g>
  ),
  inbox: (
    <g>
      <rect x="8" y="18" width="48" height="34" rx="4" fill="url(#inboxFill)" stroke="#7a4a0c" strokeWidth="2"/>
      <path d="M8 22 L32 40 L56 22" stroke="#7a4a0c" strokeWidth="2.5" fill="none" strokeLinejoin="round"/>
      <circle cx="48" cy="18" r="7" fill="#e8404a" stroke="#fff" strokeWidth="2"/>
      <text x="48" y="22" fontSize="10" fontWeight="900" textAnchor="middle" fill="#fff">3</text>
    </g>
  ),
  firecracker: (
    <g>
      <rect x="24" y="20" width="16" height="34" rx="2" fill="#e8404a" stroke="#7a0c10" strokeWidth="2"/>
      <rect x="24" y="28" width="16" height="3" fill="#f5c040"/>
      <rect x="24" y="40" width="16" height="3" fill="#f5c040"/>
      <path d="M32 20 L28 8 M32 20 L36 8 M32 20 L32 6" stroke="#f5c040" strokeWidth="2.5" strokeLinecap="round"/>
      <circle cx="32" cy="6" r="2.5" fill="#ffe878"/>
    </g>
  ),
  tournament: (
    <g>
      <rect x="16" y="12" width="32" height="22" rx="2" fill="url(#tournFill)" stroke="#7a4a0c" strokeWidth="2"/>
      <path d="M16 20 Q8 22 8 30 Q8 36 14 36 L16 36" fill="none" stroke="#7a4a0c" strokeWidth="2"/>
      <path d="M48 20 Q56 22 56 30 Q56 36 50 36 L48 36" fill="none" stroke="#7a4a0c" strokeWidth="2"/>
      <rect x="26" y="34" width="12" height="8" fill="#9a6a3a" stroke="#7a4a0c" strokeWidth="2"/>
      <rect x="20" y="42" width="24" height="6" rx="1" fill="#9a6a3a" stroke="#7a4a0c" strokeWidth="2"/>
      <path d="M26 18 L32 26 L38 18" stroke="#7a4a0c" strokeWidth="2" fill="#f5c040"/>
    </g>
  ),
  task: (
    <g>
      <rect x="12" y="8" width="40" height="48" rx="3" fill="url(#taskFill)" stroke="#7a4a0c" strokeWidth="2"/>
      <rect x="20" y="6" width="24" height="8" rx="2" fill="#9a6a3a" stroke="#7a4a0c" strokeWidth="2"/>
      <path d="M18 22 L22 26 L30 18" stroke="#2a9a20" strokeWidth="3" strokeLinecap="round" fill="none"/>
      <rect x="34" y="20" width="12" height="2" fill="#7a4a0c"/>
      <path d="M18 36 L22 40 L30 32" stroke="#2a9a20" strokeWidth="3" strokeLinecap="round" fill="none"/>
      <rect x="34" y="34" width="12" height="2" fill="#7a4a0c"/>
      <rect x="18" y="46" width="4" height="4" fill="none" stroke="#7a4a0c" strokeWidth="2"/>
      <rect x="28" y="48" width="16" height="2" fill="#7a4a0c"/>
    </g>
  ),
  collection: (
    <g>
      <rect x="8" y="12" width="20" height="20" rx="2" fill="#7fb3e8" stroke="#7a4a0c" strokeWidth="2"/>
      <rect x="36" y="12" width="20" height="20" rx="2" fill="#e88c7f" stroke="#7a4a0c" strokeWidth="2"/>
      <rect x="8" y="40" width="20" height="20" rx="2" fill="#4fd080" stroke="#7a4a0c" strokeWidth="2"/>
      <rect x="36" y="40" width="20" height="20" rx="2" fill="#f5c040" stroke="#7a4a0c" strokeWidth="2"/>
      <circle cx="18" cy="22" r="4" fill="#fff"/>
      <path d="M42 16 L46 22 L56 22 L48 28 L50 36 L46 30 L42 36 L44 28 L36 22 L46 22" fill="#fff"/>
    </g>
  ),
  decorate: (
    <g>
      <rect x="14" y="10" width="36" height="22" rx="4" fill="url(#hammerHead)" stroke="#3a2312" strokeWidth="2"/>
      <rect x="28" y="30" width="8" height="26" rx="3" fill="#9a6a3a" stroke="#3a2312" strokeWidth="2"/>
      <path d="M8 50 L22 50" stroke="#2a9a20" strokeWidth="4" strokeLinecap="round"/>
      <path d="M42 50 L56 50" stroke="#2a9a20" strokeWidth="4" strokeLinecap="round"/>
    </g>
  ),
  upgrade: (
    <g>
      <circle cx="32" cy="32" r="26" fill="url(#upgradeFill)" stroke="#fff" strokeWidth="3"/>
      <path d="M32 14 L48 34 L40 34 L40 50 L24 50 L24 34 L16 34 Z" fill="#fff"/>
    </g>
  ),
  roulette: (
    <g>
      <circle cx="32" cy="32" r="26" fill="url(#rouletteOuter)" stroke="#7a4a0c" strokeWidth="2.5"/>
      <circle cx="32" cy="32" r="20" fill="none" stroke="#7a4a0c" strokeWidth="1.5"/>
      {/* 8 wedges via clipped circles */}
      <g>
        <path d="M32 32 L32 8 A24 24 0 0 1 48.97 14.97 Z" fill="#e8404a"/>
        <path d="M32 32 L48.97 14.97 A24 24 0 0 1 56 32 Z" fill="#f5c040"/>
        <path d="M32 32 L56 32 A24 24 0 0 1 48.97 48.97 Z" fill="#4a7bc4"/>
        <path d="M32 32 L48.97 48.97 A24 24 0 0 1 32 56 Z" fill="#4fd080"/>
        <path d="M32 32 L32 56 A24 24 0 0 1 15.03 48.97 Z" fill="#e8404a"/>
        <path d="M32 32 L15.03 48.97 A24 24 0 0 1 8 32 Z" fill="#f5c040"/>
        <path d="M32 32 L8 32 A24 24 0 0 1 15.03 15.03 Z" fill="#4a7bc4"/>
        <path d="M32 32 L15.03 15.03 A24 24 0 0 1 32 8 Z" fill="#4fd080"/>
      </g>
      <circle cx="32" cy="32" r="6" fill="url(#coinInner)" stroke="#7a4a0c" strokeWidth="2"/>
      {/* pointer at top */}
      <path d="M32 2 L27 12 L37 12 Z" fill="#fff" stroke="#7a4a0c" strokeWidth="2" strokeLinejoin="round"/>
    </g>
  ),
  adPlay: (
    <g>
      <rect x="6" y="14" width="52" height="36" rx="4" fill="#1a1a20" stroke="#7a4a0c" strokeWidth="2"/>
      <path d="M28 24 L44 32 L28 40 Z" fill="#fff"/>
      <rect x="6" y="6" width="18" height="10" rx="2" fill="#e8404a" stroke="#7a4a0c" strokeWidth="1.5"/>
      <text x="15" y="14" fontSize="8" fontWeight="900" textAnchor="middle" fill="#fff" fontFamily="Baloo 2">AD</text>
    </g>
  ),
  ticket: (
    <g>
      <path d="M8 22 L8 42 Q14 42 14 36 Q14 30 14 28 Q14 22 8 22 Z
               M8 22 L56 22 Q56 22 56 28 Q50 30 50 32 Q50 34 56 36 Q56 42 56 42 L8 42"
        fill="url(#ticketFill)" stroke="#7a4a0c" strokeWidth="2" strokeLinejoin="round"/>
      <path d="M22 22 L22 42" stroke="#7a4a0c" strokeWidth="1.5" strokeDasharray="3 3"/>
      <text x="38" y="36" fontSize="13" fontWeight="900" textAnchor="middle" fill="#7a4a0c" fontFamily="Baloo 2">1</text>
    </g>
  ),
  streakStar: (
    <g>
      <path d="M32 4 L40 22 L60 25 L45 40 L50 60 L32 49 L14 60 L19 40 L4 25 L24 22 Z"
        fill="url(#streakStarFill)" stroke="#7a1a58" strokeWidth="2" strokeLinejoin="round"/>
      <path d="M32 12 L37 23 L28 22 Z" fill="rgba(255,255,255,.55)"/>
      <circle cx="32" cy="32" r="9" fill="#fff" stroke="#7a1a58" strokeWidth="1.5"/>
      <path d="M32 26 L34 30 L38 30 L35 33 L36 37 L32 35 L28 37 L29 33 L26 30 L30 30 Z"
        fill="#d83098"/>
    </g>
  ),
  rewardBox: (
    <g>
      <rect x="8" y="24" width="48" height="32" rx="3" fill="url(#rewardBoxBody)" stroke="#7a4a0c" strokeWidth="2"/>
      <rect x="6" y="18" width="52" height="10" rx="2" fill="url(#rewardBoxLid)" stroke="#7a4a0c" strokeWidth="2"/>
      <rect x="28" y="18" width="8" height="38" fill="#e88030" stroke="#7a4a0c" strokeWidth="1.5"/>
      <path d="M26 12 Q32 4 38 12 L38 18 L26 18 Z" fill="none" stroke="#e88030" strokeWidth="3"/>
      <circle cx="26" cy="14" r="2" fill="#ffd85a"/>
      <circle cx="38" cy="14" r="2" fill="#ffd85a"/>
    </g>
  ),
  plusCard: (
    <g>
      <rect x="14" y="8" width="36" height="48" rx="4" fill="#fff" stroke="#7a4a0c" strokeWidth="2"/>
      <rect x="14" y="8" width="36" height="8" fill="#4fd080"/>
      <path d="M32 22 L32 46 M20 34 L44 34" stroke="#4fd080" strokeWidth="6" strokeLinecap="round"/>
      <text x="32" y="52" fontSize="8" fontWeight="900" textAnchor="middle" fill="#7a4a0c" fontFamily="Baloo 2">+1</text>
    </g>
  ),
  extraDeck: (
    <g>
      <rect x="18" y="14" width="32" height="44" rx="3" fill="#c62a28" stroke="#7a0c10" strokeWidth="2"/>
      <rect x="14" y="10" width="32" height="44" rx="3" fill="#e8404a" stroke="#7a0c10" strokeWidth="2"/>
      <rect x="10" y="6" width="32" height="44" rx="3" fill="#ff6070" stroke="#7a0c10" strokeWidth="2"/>
      <path d="M22 22 L26 22 L26 18 L30 18 L30 22 L34 22 L34 26 L30 26 L30 30 L26 30 L26 26 L22 26 Z" fill="#fff"/>
    </g>
  ),
  giveUp: (
    <g>
      <path d="M20 10 L44 10 Q44 34 44 48 Q44 52 40 52 L24 52 Q20 52 20 48 Q20 34 20 10 Z"
        fill="url(#giveUpFill)" stroke="#7a4a0c" strokeWidth="2" strokeLinejoin="round"/>
      <rect x="16" y="6" width="32" height="8" rx="1" fill="#fff" stroke="#7a4a0c" strokeWidth="2"/>
      <path d="M24 22 L40 42 M40 22 L24 42" stroke="#e8404a" strokeWidth="4" strokeLinecap="round"/>
    </g>
  ),
  shop: (
    <g>
      <path d="M10 22 L14 12 L50 12 L54 22 L54 26 L10 26 Z" fill="url(#shopRoof)" stroke="#7a4a0c" strokeWidth="2" strokeLinejoin="round"/>
      <rect x="10" y="26" width="44" height="28" fill="url(#shopBody)" stroke="#7a4a0c" strokeWidth="2"/>
      <rect x="26" y="34" width="12" height="20" fill="#7a4a0c"/>
      <circle cx="35" cy="44" r="1.2" fill="#ffe878"/>
      <rect x="14" y="30" width="6" height="6" fill="#7fb3e8" stroke="#7a4a0c" strokeWidth="1"/>
      <rect x="44" y="30" width="6" height="6" fill="#7fb3e8" stroke="#7a4a0c" strokeWidth="1"/>
    </g>
  ),
  // Cat mascot — orange tabby sitting upright (placeholder for branded mascot)
  catMascot: (
    <g>
      {/* Tail curling around */}
      <path d="M14 50 Q4 50 4 40 Q4 32 12 32 Q14 32 14 36"
        fill="none" stroke="#7a3a08" strokeWidth="6" strokeLinecap="round"/>
      <path d="M14 50 Q5 50 5 40 Q5 33 12 33"
        fill="none" stroke="#e88030" strokeWidth="4" strokeLinecap="round"/>
      {/* Body (sitting) */}
      <ellipse cx="32" cy="46" rx="18" ry="14" fill="url(#catBody)" stroke="#7a3a08" strokeWidth="1.8"/>
      <ellipse cx="32" cy="50" rx="10" ry="6" fill="#fff5e0"/>
      {/* Front paws */}
      <ellipse cx="24" cy="56" rx="5" ry="4" fill="url(#catBody)" stroke="#7a3a08" strokeWidth="1.5"/>
      <ellipse cx="40" cy="56" rx="5" ry="4" fill="url(#catBody)" stroke="#7a3a08" strokeWidth="1.5"/>
      {/* Head */}
      <ellipse cx="32" cy="26" rx="14" ry="12" fill="url(#catBody)" stroke="#7a3a08" strokeWidth="1.8"/>
      {/* Ears */}
      <path d="M20 18 L18 8 L26 14 Z" fill="url(#catBody)" stroke="#7a3a08" strokeWidth="1.8" strokeLinejoin="round"/>
      <path d="M44 18 L46 8 L38 14 Z" fill="url(#catBody)" stroke="#7a3a08" strokeWidth="1.8" strokeLinejoin="round"/>
      <path d="M21 16 L20 11 L24 14 Z" fill="#ffb070"/>
      <path d="M43 16 L44 11 L40 14 Z" fill="#ffb070"/>
      {/* Stripes on head */}
      <path d="M26 14 L28 18 M32 12 L32 16 M38 14 L36 18" stroke="#7a3a08" strokeWidth="1.5" strokeLinecap="round"/>
      {/* Eyes (closed/happy) */}
      <path d="M24 26 Q26 24 28 26" fill="none" stroke="#3a1a00" strokeWidth="2" strokeLinecap="round"/>
      <path d="M36 26 Q38 24 40 26" fill="none" stroke="#3a1a00" strokeWidth="2" strokeLinecap="round"/>
      {/* Cheek blush */}
      <circle cx="22" cy="30" r="2.2" fill="#ff8aaa" opacity=".6"/>
      <circle cx="42" cy="30" r="2.2" fill="#ff8aaa" opacity=".6"/>
      {/* Nose + mouth */}
      <path d="M30 30 L34 30 L32 32 Z" fill="#3a1a00"/>
      <path d="M32 32 Q30 34 28 33 M32 32 Q34 34 36 33" fill="none" stroke="#3a1a00" strokeWidth="1.4" strokeLinecap="round"/>
      {/* Whiskers */}
      <path d="M22 31 L14 30 M22 32 L14 33 M42 31 L50 30 M42 32 L50 33" stroke="#7a3a08" strokeWidth="1" strokeLinecap="round"/>
    </g>
  ),
  // Treasure chest — wider, used as reward box at bottom of screen
  treasureChest: (
    <g>
      {/* Body */}
      <rect x="6" y="30" width="52" height="28" rx="3" fill="url(#chestBody)" stroke="#5a2a04" strokeWidth="2.5"/>
      {/* Lid */}
      <path d="M6 30 Q6 14 32 14 Q58 14 58 30 Z" fill="url(#chestLid)" stroke="#5a2a04" strokeWidth="2.5" strokeLinejoin="round"/>
      {/* Wood planks */}
      <line x1="6" y1="44" x2="58" y2="44" stroke="#5a2a04" strokeWidth="1.5"/>
      <line x1="22" y1="30" x2="22" y2="58" stroke="#5a2a04" strokeWidth="1.2" opacity=".5"/>
      <line x1="42" y1="30" x2="42" y2="58" stroke="#5a2a04" strokeWidth="1.2" opacity=".5"/>
      {/* Metal bands */}
      <rect x="4" y="28" width="56" height="4" fill="#c9891a" stroke="#5a2a04" strokeWidth="1"/>
      <rect x="4" y="56" width="56" height="4" rx="1" fill="#c9891a" stroke="#5a2a04" strokeWidth="1"/>
      {/* Lock */}
      <rect x="28" y="38" width="8" height="10" rx="1" fill="#ffd85a" stroke="#5a2a04" strokeWidth="1.5"/>
      <circle cx="32" cy="42" r="1.5" fill="#5a2a04"/>
      {/* Highlight */}
      <path d="M10 18 Q12 16 18 17" fill="none" stroke="rgba(255,255,255,.5)" strokeWidth="2" strokeLinecap="round"/>
    </g>
  ),
  // In-game boosters
  bomb: (
    <g>
      <circle cx="30" cy="38" r="20" fill="url(#bombFill)" stroke="#1a1a1a" strokeWidth="2"/>
      <rect x="28" y="14" width="4" height="10" fill="#9a6a3a"/>
      <path d="M32 14 Q40 8 44 12 Q46 16 42 18" stroke="#f5c040" strokeWidth="2" fill="none"/>
      <circle cx="42" cy="10" r="3" fill="#ff6020"/>
      <ellipse cx="22" cy="30" rx="5" ry="3" fill="rgba(255,255,255,.35)"/>
    </g>
  ),
  wild: (
    <g>
      <path d="M32 8 L44 20 L56 32 L44 44 L32 56 L20 44 L8 32 L20 20 Z"
        fill="url(#wildFill)" stroke="#fff" strokeWidth="3" strokeLinejoin="round"/>
      <text x="32" y="40" fontSize="22" fontWeight="900" textAnchor="middle" fill="#fff" fontFamily="Baloo 2">★</text>
    </g>
  ),
  undo: (
    <g>
      <path d="M14 30 L14 20 L22 28 Q32 14 46 22 Q58 32 50 46 Q44 54 34 52"
        stroke="#4b7bc4" strokeWidth="5" fill="none" strokeLinecap="round" strokeLinejoin="round"/>
      <path d="M8 30 L14 22 L20 30 Z" fill="#4b7bc4"/>
    </g>
  ),
};

const ICON_DEFS = (
  <defs>
    <linearGradient id="coinOuter" x1="0" y1="0" x2="0" y2="1">
      <stop offset="0" stopColor="#ffd85a"/><stop offset="1" stopColor="#d18820"/>
    </linearGradient>
    <linearGradient id="coinInner" x1="0" y1="0" x2="0" y2="1">
      <stop offset="0" stopColor="#ffe878"/><stop offset="1" stopColor="#e8a030"/>
    </linearGradient>
    <linearGradient id="hammerHead" x1="0" y1="0" x2="0" y2="1">
      <stop offset="0" stopColor="#d0d5db"/><stop offset="1" stopColor="#6a7078"/>
    </linearGradient>
    <linearGradient id="homeFill" x1="0" y1="0" x2="0" y2="1">
      <stop offset="0" stopColor="#ff8a4a"/><stop offset="1" stopColor="#e8541c"/>
    </linearGradient>
    <linearGradient id="settingFill" x1="0" y1="0" x2="0" y2="1">
      <stop offset="0" stopColor="#b0b8c4"/><stop offset="1" stopColor="#6a7078"/>
    </linearGradient>
    <linearGradient id="starFill" x1="0" y1="0" x2="0" y2="1">
      <stop offset="0" stopColor="#fff070"/><stop offset="1" stopColor="#f5a020"/>
    </linearGradient>
    <linearGradient id="crownFill" x1="0" y1="0" x2="0" y2="1">
      <stop offset="0" stopColor="#ffe060"/><stop offset="1" stopColor="#d88a10"/>
    </linearGradient>
    <linearGradient id="crownBand" x1="0" y1="0" x2="0" y2="1">
      <stop offset="0" stopColor="#e8a030"/><stop offset="1" stopColor="#b3740f"/>
    </linearGradient>
    <linearGradient id="checkFill" x1="0" y1="0" x2="0" y2="1">
      <stop offset="0" stopColor="#6fd080"/><stop offset="1" stopColor="#3a9830"/>
    </linearGradient>
    <linearGradient id="leaderFill" x1="0" y1="0" x2="0" y2="1">
      <stop offset="0" stopColor="#ffd85a"/><stop offset="1" stopColor="#d18820"/>
    </linearGradient>
    <linearGradient id="inboxFill" x1="0" y1="0" x2="0" y2="1">
      <stop offset="0" stopColor="#ffb070"/><stop offset="1" stopColor="#e88030"/>
    </linearGradient>
    <linearGradient id="tournFill" x1="0" y1="0" x2="0" y2="1">
      <stop offset="0" stopColor="#ffe878"/><stop offset="1" stopColor="#e8a030"/>
    </linearGradient>
    <linearGradient id="taskFill" x1="0" y1="0" x2="0" y2="1">
      <stop offset="0" stopColor="#fff4d0"/><stop offset="1" stopColor="#e8c880"/>
    </linearGradient>
    <linearGradient id="upgradeFill" x1="0" y1="0" x2="0" y2="1">
      <stop offset="0" stopColor="#6fd080"/><stop offset="1" stopColor="#3a9830"/>
    </linearGradient>
    <linearGradient id="bombFill" x1="0" y1="0" x2="0" y2="1">
      <stop offset="0" stopColor="#4a4a52"/><stop offset="1" stopColor="#1a1a1a"/>
    </linearGradient>
    <linearGradient id="wildFill" x1="0" y1="0" x2="0" y2="1">
      <stop offset="0" stopColor="#b060e8"/><stop offset="1" stopColor="#6a20a8"/>
    </linearGradient>
    <linearGradient id="rouletteOuter" x1="0" y1="0" x2="0" y2="1">
      <stop offset="0" stopColor="#ffe878"/><stop offset="1" stopColor="#d88a10"/>
    </linearGradient>
    <linearGradient id="ticketFill" x1="0" y1="0" x2="0" y2="1">
      <stop offset="0" stopColor="#ffd85a"/><stop offset="1" stopColor="#e8a030"/>
    </linearGradient>
    <linearGradient id="streakStarFill" x1="0" y1="0" x2="0" y2="1">
      <stop offset="0" stopColor="#ff70c8"/><stop offset="1" stopColor="#c030a0"/>
    </linearGradient>
    <linearGradient id="rewardBoxBody" x1="0" y1="0" x2="0" y2="1">
      <stop offset="0" stopColor="#ffd08a"/><stop offset="1" stopColor="#d87830"/>
    </linearGradient>
    <linearGradient id="rewardBoxLid" x1="0" y1="0" x2="0" y2="1">
      <stop offset="0" stopColor="#ffe090"/><stop offset="1" stopColor="#d88a10"/>
    </linearGradient>
    <linearGradient id="giveUpFill" x1="0" y1="0" x2="0" y2="1">
      <stop offset="0" stopColor="#fff4d0"/><stop offset="1" stopColor="#e8c880"/>
    </linearGradient>
    <linearGradient id="shopRoof" x1="0" y1="0" x2="0" y2="1">
      <stop offset="0" stopColor="#e8404a"/><stop offset="1" stopColor="#a01820"/>
    </linearGradient>
    <linearGradient id="shopBody" x1="0" y1="0" x2="0" y2="1">
      <stop offset="0" stopColor="#ffd08a"/><stop offset="1" stopColor="#d88a30"/>
    </linearGradient>
    <linearGradient id="catBody" x1="0" y1="0" x2="0" y2="1">
      <stop offset="0" stopColor="#ffb070"/><stop offset="1" stopColor="#e88030"/>
    </linearGradient>
    <linearGradient id="chestBody" x1="0" y1="0" x2="0" y2="1">
      <stop offset="0" stopColor="#a86028"/><stop offset="1" stopColor="#6a3a08"/>
    </linearGradient>
    <linearGradient id="chestLid" x1="0" y1="0" x2="0" y2="1">
      <stop offset="0" stopColor="#c98030"/><stop offset="1" stopColor="#7a4a08"/>
    </linearGradient>
  </defs>
);

const Icon = ({name, size = 32, style}) => (
  <svg width={size} height={size} viewBox="0 0 64 64" style={{display: 'block', ...style}}>
    {ICON_DEFS}
    {ICONS[name] || <text x="32" y="40" textAnchor="middle" fontSize="20">?</text>}
  </svg>
);

// CSS-drawn cityscape background (parameterized by hue)
const Cityscape = ({hue = 30, style}) => (
  <div style={{
    position: 'absolute', inset: 0, overflow: 'hidden',
    background: `linear-gradient(180deg, hsl(${hue},70%,72%) 0%, hsl(${hue+20},60%,86%) 40%, hsl(${hue+40},30%,92%) 100%)`,
    ...style,
  }}>
    {/* Sun */}
    <div style={{position:'absolute', top:70, right:180, width:120, height:120,
      borderRadius:'50%', background:`radial-gradient(circle, #fff7c0, hsl(${hue+10},80%,70%) 70%)`,
      boxShadow:`0 0 80px hsla(${hue+10},80%,70%,.6)`}} />
    {/* Clouds */}
    <div style={{position:'absolute', top:110, left:160, width:180, height:30,
      background:'rgba(255,255,255,.7)', borderRadius:999, filter:'blur(1px)'}} />
    <div style={{position:'absolute', top:80, left:900, width:220, height:38,
      background:'rgba(255,255,255,.6)', borderRadius:999, filter:'blur(1px)'}} />
    {/* Mountains */}
    <div style={{position:'absolute', bottom:260, left:0, right:0, height:180,
      background:`linear-gradient(180deg, hsl(${hue-10},25%,60%), hsl(${hue-10},25%,45%))`,
      clipPath:'polygon(0 100%, 10% 50%, 25% 70%, 40% 30%, 55% 65%, 70% 40%, 85% 60%, 100% 45%, 100% 100%)'}} />
    {/* Back buildings */}
    <div style={{position:'absolute', bottom:180, left:0, right:0, display:'flex', alignItems:'flex-end', justifyContent:'space-around'}}>
      {[90,130,100,160,110,140,95,150,120,100].map((h,i)=>(
        <div key={i} style={{
          width: 70+i%3*20, height: h,
          background: `linear-gradient(180deg, hsl(${hue+20+i*4},50%,70%), hsl(${hue+30+i*4},55%,55%))`,
          borderTop:`4px solid hsl(${hue+20+i*4},45%,45%)`,
          borderRadius: i%2 ? '6px 6px 0 0' : '16px 4px 0 0',
          boxShadow:'inset -8px 0 0 rgba(0,0,0,.12)',
          position:'relative',
        }}>
          {/* windows */}
          <div style={{position:'absolute',inset:'20% 15%',display:'grid',
            gridTemplateColumns:'repeat(2,1fr)', gap:4}}>
            {Array(6).fill(0).map((_,j)=>(
              <div key={j} style={{background:'rgba(255,248,200,.85)', borderRadius:2, height:8}}/>
            ))}
          </div>
        </div>
      ))}
    </div>
    {/* Ground */}
    <div style={{position:'absolute', bottom:0, left:0, right:0, height:180,
      background:`linear-gradient(180deg, hsl(${hue+50},40%,65%), hsl(${hue+60},45%,48%))`}} />
    {/* Road */}
    <div style={{position:'absolute', bottom:40, left:0, right:0, height:60,
      background:'#3a3a42', boxShadow:'inset 0 3px 6px rgba(0,0,0,.4)'}} />
    <div style={{position:'absolute', bottom:68, left:0, right:0, height:4,
      background:'repeating-linear-gradient(90deg, #f5c040 0 40px, transparent 40px 80px)'}} />
    {/* Trees */}
    {[80, 300, 520, 780, 1020, 1200].map((x,i)=>(
      <div key={i} style={{position:'absolute', bottom:100, left:x}}>
        <div style={{width:10, height:24, background:'#6a3a10', margin:'0 auto', borderRadius:2}}/>
        <div style={{width:40, height:40, marginTop:-8,
          background:`radial-gradient(circle, hsl(${hue+70},50%,55%), hsl(${hue+80},50%,35%))`,
          borderRadius:'50%', boxShadow:'inset -6px -4px 0 rgba(0,0,0,.15)'}}/>
      </div>
    ))}
  </div>
);

// CSS-drawn playing card (face + back), replaces PlayingCard
const SvgCard = ({n, suit = 'red', faceDown, dim, onClick, style}) => {
  const w = style?.width || 54;
  const h = style?.height || 76;
  const suitChar = {red: {h: '♥', d: '♦'}, black: {s: '♠', c: '♣'}};
  const glyph = suit === 'red' ? '♥' : '♠';
  const color = suit === 'red' ? '#d8201c' : '#1a1a20';
  const rankLabel = (v) => v === 1 ? 'A' : v === 11 ? 'J' : v === 12 ? 'Q' : v === 13 ? 'K' : String(v);

  if (faceDown) {
    return (
      <div onClick={!dim ? onClick : undefined} style={{
        width: w, height: h, borderRadius: 6,
        background: 'linear-gradient(135deg, #4fa0e8 0%, #2a6abf 50%, #4fa0e8 100%)',
        border: '3px solid #fff',
        boxShadow: '0 3px 0 rgba(0,0,0,.45), 0 2px 4px rgba(0,0,0,.3)',
        position: 'relative', overflow: 'hidden', cursor: onClick && !dim ? 'pointer' : 'default',
        ...style, width: w, height: h,
      }}>
        <div style={{position:'absolute', inset: 2, border: '1px solid rgba(255,255,255,.4)', borderRadius: 4,
          background: 'repeating-linear-gradient(45deg, transparent 0 6px, rgba(255,255,255,.1) 6px 7px)'}}/>
      </div>
    );
  }
  return (
    <div onClick={!dim ? onClick : undefined} style={{
      width: w, height: h, borderRadius: 6,
      background: '#fff',
      boxShadow: '0 3px 0 rgba(0,0,0,.45), 0 2px 4px rgba(0,0,0,.3)',
      position: 'relative', overflow: 'hidden', cursor: onClick && !dim ? 'pointer' : 'default',
      opacity: dim ? 0.45 : 1,
      border: '2px solid #f0e2c7',
      ...style, width: w, height: h,
    }}>
      <div style={{position:'absolute', top: 3, left: 4, color, fontWeight: 900, lineHeight: 1,
        fontFamily: 'Baloo 2, sans-serif', textAlign:'center'}}>
        <div style={{fontSize: w*0.32}}>{rankLabel(n)}</div>
        <div style={{fontSize: w*0.26, marginTop: -2}}>{glyph}</div>
      </div>
      <div style={{position:'absolute', bottom: 3, right: 4, color, fontWeight: 900, lineHeight: 1,
        fontFamily: 'Baloo 2, sans-serif', textAlign:'center', transform:'rotate(180deg)'}}>
        <div style={{fontSize: w*0.32}}>{rankLabel(n)}</div>
        <div style={{fontSize: w*0.26, marginTop: -2}}>{glyph}</div>
      </div>
      <div style={{position:'absolute', inset:0, display:'flex', alignItems:'center', justifyContent:'center',
        color, fontSize: w*0.55, fontWeight:900}}>{glyph}</div>
    </div>
  );
};

Object.assign(window, {Icon, Cityscape, SvgCard});
