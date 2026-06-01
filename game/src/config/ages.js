// ages.js — 시대(Age) 테마 설정
// ─────────────────────────────────────────────────────────────
// ⚠️ 복구 파일: 원본 src/config/ages.js 가 2026-05-29 유실되어
//    배포 번들 city2048/assets/buildings-D3phTTcr.js 에서 복원함.
//    데이터(속성/값)는 100% 보존본이며, 변수명만 가독성 있게 재명명함.
//    원본 구조와 다를 수 있으니 빌드 연결 시 검증 필요.
// ─────────────────────────────────────────────────────────────

// 각 시대: id, 영문/한글명, 아이콘, 배경 그라데이션, 보드 색상,
//          14단계 타일 색상 팔레트([밝은면, 중간면, 어두운면]),
//          14단계 빌딩 영문/한글 이름

const classic = {
  id: "classic",
  name: "Classic City",
  nameKo: "클래식 시티",
  icon: "🏙",
  bgFrom: "#7CB7E8",
  bgTo: "#C9E4F2",
  boardBg: "#1F2B52",
  boardCell: "rgba(255,255,255,0.06)",
  tilePalette: [
    ["#FFE7BC", "#A07248", "#7C5230"],
    ["#F4D8A1", "#955A2F", "#6B3D1D"],
    ["#E2C58C", "#7B3F1F", "#5A2C12"],
    ["#E5B97D", "#C84D2F", "#8A2A19"],
    ["#EFD7B6", "#5C7DA8", "#37547A"],
    ["#F1D9A6", "#3F76C3", "#22507F"],
    ["#E0E6EE", "#3A6FB2", "#1E4880"],
    ["#D6DEE8", "#2D5BA2", "#143C6F"],
    ["#CDD7E5", "#1E7ED6", "#0F4886"],
    ["#E5ECF5", "#1565C0", "#0A3160"],
    ["#F5DA62", "#D88F00", "#8A4F00"],
    ["#F1E8FF", "#8B4DD8", "#4D1E94"],
    ["#FFD86A", "#F88018", "#8A3500"],
    ["#FFFFFF", "#F5B728", "#8A3500"],
  ],
  names: ["Tent", "Shack", "Row House", "Brick House", "Townhouse", "Apartment", "Office Tower", "Skyscraper", "Twin Tower", "Spire", "Golden Tower", "Crystal Tower", "Solar Tower", "World Tower"],
  namesKo: ["텐트", "판잣집", "연립주택", "벽돌집", "타운하우스", "아파트", "오피스 타워", "고층 빌딩", "트윈 타워", "첨탑", "황금 타워", "크리스털 타워", "태양 타워", "세계의 탑"],
};

const egypt = {
  id: "egypt",
  name: "Ancient Egypt",
  nameKo: "고대 이집트",
  icon: "𓂀",
  bgFrom: "#F5C76A",
  bgTo: "#F2E1B0",
  boardBg: "#5A3A12",
  boardCell: "rgba(255,236,180,0.08)",
  tilePalette: [
    ["#FBE2A8", "#A0794A", "#6E5230"],
    ["#F4D08A", "#A06536", "#6B401D"],
    ["#EDC077", "#8B4922", "#5E2E11"],
    ["#FFE89A", "#C68A3A", "#7A5215"],
    ["#FFE48A", "#D89A30", "#7C5614"],
    ["#FFDD78", "#D67D26", "#7C460F"],
    ["#FFCB68", "#C0631E", "#702F0A"],
    ["#FFE38A", "#B85A1E", "#651B05"],
    ["#FFEE9D", "#D89A30", "#6E3B0E"],
    ["#FFD86A", "#D88F00", "#5A2A05"],
    ["#FFE07A", "#E89A18", "#7A3508"],
    ["#FFEEAA", "#F0B528", "#8A4F00"],
    ["#FFE57A", "#F88018", "#8A3500"],
    ["#FFFFFF", "#F5B728", "#8A3500"],
  ],
  names: ["Reed Hut", "Mud House", "Granary", "Sandstone Tomb", "Mastaba", "Obelisk", "Mortuary Temple", "Step Pyramid", "Red Pyramid", "Great Pyramid", "Sphinx", "Karnak Temple", "Abu Simbel", "Pharaoh's Throne"],
  namesKo: ["갈대 오두막", "진흙집", "곡물창고", "사암 무덤", "마스타바", "오벨리스크", "장제신전", "계단 피라미드", "붉은 피라미드", "대피라미드", "스핑크스", "카르낙 신전", "아부심벨", "파라오의 왕좌"],
};

const medieval = {
  id: "medieval",
  name: "Medieval Age",
  nameKo: "중세 시대",
  icon: "🏰",
  bgFrom: "#6B8E5A",
  bgTo: "#C8D9A8",
  boardBg: "#2A3818",
  boardCell: "rgba(220,235,180,0.08)",
  tilePalette: [
    ["#EFD7B6", "#7B3F1F", "#5A2C12"],
    ["#E5C490", "#5A3A1A", "#3A2010"],
    ["#D7B988", "#7B3F1F", "#4A2410"],
    ["#C9C3B0", "#6E7250", "#3E4225"],
    ["#BEC2B0", "#5A6E48", "#2E3A20"],
    ["#A8AEA0", "#4F5A3A", "#252E18"],
    ["#C8C0A8", "#6E5230", "#3A2810"],
    ["#9DA28C", "#5A6E48", "#2E3A20"],
    ["#A8AEA0", "#4F5A3A", "#252E18"],
    ["#B4BAA8", "#3F5C28", "#1E2E12"],
    ["#D8C68A", "#A05A1E", "#5A2A05"],
    ["#E5C68A", "#C68A3A", "#5A3A12"],
    ["#FFE57A", "#D88F00", "#8A3500"],
    ["#FFFFFF", "#F5B728", "#8A3500"],
  ],
  names: ["Hovel", "Cottage", "Tavern", "Watchtower", "Barracks", "Stone Keep", "Manor House", "Motte-Bailey", "Barbican", "Castle", "Cathedral", "Royal Palace", "Citadel", "King's Crown"],
  namesKo: ["움막", "오두막", "선술집", "망루", "병영", "석조 요새", "영주 저택", "목책 성", "성문 요새", "성", "대성당", "왕궁", "요새 도시", "왕관"],
};

const industrial = {
  id: "industrial",
  name: "Industrial Age",
  nameKo: "산업화 시대",
  icon: "🏭",
  bgFrom: "#8A7A6A",
  bgTo: "#D4C9B8",
  boardBg: "#2D2418",
  boardCell: "rgba(255,235,200,0.06)",
  tilePalette: [
    ["#D8C8B0", "#6E4A2E", "#3E2818"],
    ["#C4A88A", "#7B3F1F", "#4A2410"],
    ["#B89C7A", "#5A3A1A", "#3A2010"],
    ["#C4856A", "#7B3818", "#4A1F0A"],
    ["#A85A38", "#5A1E0A", "#2E0A02"],
    ["#8E7A5C", "#3E2818", "#1E1408"],
    ["#A89A78", "#5A4828", "#2E2410"],
    ["#7E6A50", "#3A2E18", "#1E1808"],
    ["#9A8E70", "#4A3818", "#241A08"],
    ["#B89A6A", "#7A5A28", "#3A2810"],
    ["#D8B868", "#A07228", "#5A3A0E"],
    ["#E5C68A", "#C68A3A", "#7A5215"],
    ["#FFE57A", "#F88018", "#8A3500"],
    ["#FFFFFF", "#F5B728", "#8A3500"],
  ],
  names: ["Craftsman Hut", "Woodmill", "Watermill", "Smithy", "Brick Works", "Ironworks", "Textile Mill", "Coal Pit", "Steel Foundry", "Locomotive Depot", "Power Station", "Clock Tower", "Industrial Capital", "Iron Crown"],
  namesKo: ["장인의 움막", "목재 방앗간", "물레방아", "대장간", "벽돌 공장", "철공소", "방직 공장", "탄광", "제철소", "기관차 기지", "발전소", "시계탑", "산업 도시", "강철 왕관"],
};

const china = {
  id: "china",
  name: "Ancient China",
  nameKo: "고대 중국",
  icon: "🏯",
  bgFrom: "#D94F3A",
  bgTo: "#F2C880",
  boardBg: "#3A1A0A",
  boardCell: "rgba(255,200,100,0.07)",
  tilePalette: [
    ["#F5DEB0", "#8B3A2A", "#5A1A0A"],
    ["#F0C898", "#A03828", "#6A2018"],
    ["#E8B880", "#B04030", "#702818"],
    ["#F0C048", "#C84820", "#7A2808"],
    ["#FFD060", "#D05028", "#8A3010"],
    ["#E8C858", "#C84020", "#782808"],
    ["#D4A840", "#A03020", "#601808"],
    ["#E8B030", "#B83818", "#701808"],
    ["#D89828", "#8B2C10", "#581008"],
    ["#F0A820", "#A02808", "#600808"],
    ["#FFD040", "#C84010", "#782008"],
    ["#FFE060", "#D85020", "#8A2808"],
    ["#FFE880", "#E86818", "#8A3500"],
    ["#FFFFFF", "#F5B728", "#8A3500"],
  ],
  names: ["Reed Hut", "Bamboo Cottage", "Farmstead", "Siheyuan", "Village Shrine", "Pavilion", "Pagoda", "Gate Tower", "City Wall", "Imperial Court", "Temple of Heaven", "Ancestral Hall", "Forbidden City", "Great Wall"],
  namesKo: ["갈대집", "대나무 오두막", "농가", "사합원", "마을 사당", "정자", "탑", "성루", "성벽", "황궁 뜰", "천단", "태묘", "자금성", "만리장성"],
};

const global = {
  id: "global",
  name: "Global City",
  nameKo: "글로벌 시티",
  icon: "🌏",
  bgFrom: "#2E6FA8",
  bgTo: "#B8DCED",
  boardBg: "#0A1830",
  boardCell: "rgba(80,160,240,0.07)",
  tilePalette: [
    ["#D0E8F8", "#2E6FA8", "#0A3A68"],
    ["#B8D8F0", "#2868A0", "#083060"],
    ["#A8C8E8", "#2060A0", "#063068"],
    ["#C8E0F0", "#1E78B8", "#083870"],
    ["#B0D0E8", "#1870B0", "#064070"],
    ["#98C0E0", "#1068A8", "#043868"],
    ["#A8D0F0", "#0860A8", "#022860"],
    ["#B8D8F8", "#1878C0", "#043870"],
    ["#C8E8FF", "#2080C8", "#044080"],
    ["#D8EEFF", "#2888D0", "#064888"],
    ["#E0F0FF", "#3898D8", "#0A5090"],
    ["#E8F4FF", "#50A8E0", "#1A5898"],
    ["#F0F8FF", "#68B8E8", "#2060A0"],
    ["#FFFFFF", "#88C8F0", "#2868B0"],
  ],
  names: ["Hostel", "Studio Flat", "Boutique Hotel", "Café Quarter", "Shopping Mall", "Business Park", "Airport Hub", "Convention Center", "Science Campus", "Tech Corridor", "Smart District", "World Trade Ctr", "Mega Complex", "Global Capital"],
  namesKo: ["호스텔", "스튜디오", "부티크 호텔", "카페 거리", "쇼핑몰", "비즈니스 파크", "공항 허브", "컨벤션 센터", "사이언스 캠퍼스", "테크 회랑", "스마트 지구", "세계 무역 센터", "메가 복합단지", "세계 수도"],
};

const space = {
  id: "space",
  name: "Space City",
  nameKo: "우주 도시",
  icon: "🚀",
  bgFrom: "#0A0B1E",
  bgTo: "#0E1535",
  boardBg: "#050810",
  boardCell: "rgba(60,100,220,0.07)",
  tilePalette: [
    ["#0E1830", "#3050A0", "#5880C8"],
    ["#111838", "#3060A8", "#5888C8"],
    ["#0C1A30", "#2068B0", "#4898C8"],
    ["#0A1A30", "#1078B8", "#38A8D0"],
    ["#081820", "#0880A8", "#28B0C8"],
    ["#081820", "#0870A0", "#30B8D0"],
    ["#150820", "#5818A0", "#8840C8"],
    ["#1A0828", "#6820A8", "#A048D0"],
    ["#100818", "#4810A0", "#7030C0"],
    ["#100820", "#3810B8", "#6028D8"],
    ["#0A1820", "#1060B0", "#30A0E0"],
    ["#1A1010", "#7030B0", "#B060D8"],
    ["#C0D8FF", "#7090F0", "#3060D0"],
    ["#E8F0FF", "#A0C0F8", "#5090E0"],
  ],
  names: ["Bivouac Tent", "Habitat Pod", "Pressurized Dome", "Research Module", "Orbital Ring", "Radar Array", "Space Station", "Satellite Hub", "Orbital Tower", "Launch Port", "Planet Colony", "Terraformer", "Dyson Ring", "Galaxy City"],
  namesKo: ["비박 텐트", "거주 포드", "압력 돔", "연구 모듈", "궤도 링", "레이더 기지", "우주 정거장", "위성 허브", "궤도 타워", "우주 항구", "행성 식민지", "테라포머", "다이슨 링", "은하 도시"],
};

const stone = {
  id: "stone",
  name: "Stone Age",
  nameKo: "석기 시대",
  icon: "🔥",
  bgFrom: "#5E8C3A",
  bgTo: "#A8CC6C",
  boardBg: "#2A3C1A",
  boardCell: "rgba(180,230,120,0.09)",
  tilePalette: [
    ["#D8C190", "#6E4A2E", "#3E2818"],
    ["#C8A878", "#5A3A1A", "#3A2010"],
    ["#B89860", "#4A2E12", "#2A1808"],
    ["#A87A48", "#3A2010", "#1E1208"],
    ["#9A8E70", "#5A4828", "#2E2410"],
    ["#A89A78", "#4A3818", "#241A08"],
    ["#8E7A5C", "#3E2818", "#1E1408"],
    ["#7E6A50", "#3A2E18", "#1E1808"],
    ["#9A8E70", "#4A3818", "#241A08"],
    ["#A89A78", "#5A4828", "#2E2410"],
    ["#C4A878", "#7A5228", "#3A2510"],
    ["#D8B868", "#A07228", "#5A3A0E"],
    ["#FFE07A", "#D88F00", "#7A3508"],
    ["#FFFFFF", "#F5B728", "#8A3500"],
  ],
  names: ["Lean-to", "Grass Hut", "Cave Mouth", "Firepit", "Bone Hut", "Totem Pole", "Stone Circle", "Menhir", "Mammoth Lodge", "Rock Art", "Dolmen", "Stonehenge", "Sacred Mound", "Ancestor Altar"],
  namesKo: ["선반 쉼터", "풀 오두막", "동굴 입구", "화덕", "뼈대 집", "토템 기둥", "돌 원형", "선돌", "매머드 집", "암각화", "고인돌", "스톤헨지", "성스러운 언덕", "조상 제단"],
};

// 시대 id → 시대 데이터 (원본 export D)
export const AGES = {
  classic,
  egypt,
  medieval,
  industrial,
  china,
  global,
  space,
  stone,
};

// 시대별 빌딩 이미지 경로 (원본 export y)
// 14단계 중 12~14는 동일 랜드마크 이미지 재사용
const classicBuildingImages = [
  "assets/buildings/01_tent.png",
  "assets/buildings/02_hut.png",
  "assets/buildings/03_cottage.png",
  "assets/buildings/04_red_house.png",
  "assets/buildings/05_large_house.png",
  "assets/buildings/06_shop.png",
  "assets/buildings/07_cathedral.png",
  "assets/buildings/08_apartment.png",
  "assets/buildings/09_office.png",
  "assets/buildings/10_glass_tower.png",
  "assets/buildings/11_gold_skyscraper.png",
  "assets/buildings/12_landmark.png",
  "assets/buildings/12_landmark.png",
  "assets/buildings/12_landmark.png",
];

const makeNumberedImages = (age) =>
  ["01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "12", "12"].map(
    (n) => `assets/buildings/${age}/${n}.png`
  );

export const BUILDING_IMAGES = {
  classic: classicBuildingImages,
  stone: makeNumberedImages("stone"),
  egypt: makeNumberedImages("egypt"),
  medieval: makeNumberedImages("medieval"),
  industrial: makeNumberedImages("industrial"),
  china: makeNumberedImages("china"),
};

export default AGES;
