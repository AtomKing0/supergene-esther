// constants.js — 게임 전역 상수 (배포 번들에서 복원)
// 번들: Wo = tileNumbers, O = 그리드 크기

// 타일 단계별 숫자 (level 인덱스 0..11)
export const TILE_NUMBERS = [2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096];

// 보드 그리드 크기 (4x4)
export const GRID_SIZE = 4;

// localStorage 키 (번들에서 확인된 5개)
export const STORAGE_KEYS = {
  highScore: "city2048-hs",
  streak: "city2048-streak",
  lastClaim: "city2048-lastClaim",
  hpa: "city2048-hpa",
  howToPlaySeen: "city2048-htp",
};
