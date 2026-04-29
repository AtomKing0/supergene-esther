# 카드 간 충돌 감지 로직 (OBB Collision Detection)

## 개요

카드 간 충돌을 계산하는 로직입니다.  
이 로직으로 **충돌 판정**이 나면, 맵 데이터의 층(layer) 값이 같아도 더 아래에 있다고 판단된 카드는 `facedown` 처리됩니다.

> **문제점**: 플레이어 눈에 카드들이 착시로 잘못 배치되어 보이는 현상이 발생합니다.  
> **조치 사항**: 이러한 착시가 발생하는 맵은 라이브 서비스에서 제거해야 합니다.

---

## 설정값

| 항목 | 값 |
|---|---|
| 카드 사이즈 | `145 x 104` |
| OBB 겹침 마진 | `OBB_OVERLAP_MARGIN = 2` |

---

## 충돌 감지 방식: SAT (Separating Axis Theorem)

**OBB(Oriented Bounding Box)** 기반의 SAT 알고리즘을 사용합니다.  
두 박스의 모든 분리 축(각 박스의 x축, y축 총 4개)에 투영하여 겹침 여부를 판단합니다.

### 판정 기준

- 모든 축에서 겹침량이 `OBB_OVERLAP_MARGIN(2)` 이상이면 → **충돌**
- 하나의 축이라도 겹침량이 마진 이하이면 → **비충돌**

---

## 함수 목록

### 1. `MatchingOBB` — 핵심 OBB 충돌 판정

두 OBBBox 객체를 받아 SAT 알고리즘으로 충돌 여부를 계산합니다.

**반환값**: 충돌 시 `true`, 비충돌 시 `false`

**충돌 결과 (`CollisionResult`)에 포함되는 정보**:
- `isColliding`: 충돌 여부
- `overlap`: 최소 겹침량
- `overlapX` / `overlapY`: 축별 겹침량 근사값
- `normal`: box1 → box2 방향의 법선 벡터

```typescript
public static MatchingOBB(
    box1: OBBBox,
    box2: OBBBox,
    result?: CollisionResult
): boolean {
    const vertices1 = box1.GetVertices();
    const vertices2 = box2.GetVertices();
    const axes1 = box1.GetAxes();
    const axes2 = box2.GetAxes();

    const allAxes = [...axes1, ...axes2];

    let minOverlap = Infinity;
    let minOverlapAxis: cc.Vec2 = null;

    for (const axis of allAxes) {
        const range1 = CCcollision.ProjectVertices(vertices1, axis);
        const range2 = CCcollision.ProjectVertices(vertices2, axis);

        const overlap = CCcollision.GetOverlapAmount(range1, range2);

        // 겹침이 마진보다 작으면 충돌하지 않음
        if (overlap <= CCcollision.OBB_OVERLAP_MARGIN) {
            if (result) {
                result.isColliding = false;
                result.overlapX = 0;
                result.overlapY = 0;
                result.overlap = 0;
                result.normal = cc.Vec2.ZERO;
            }
            return false;
        }

        if (overlap < minOverlap) {
            minOverlap = overlap;
            minOverlapAxis = axis;
        }
    }

    if (result) {
        result.isColliding = true;
        result.overlap = minOverlap;

        if (minOverlapAxis) {
            result.overlapX = Math.abs(minOverlap * minOverlapAxis.x);
            result.overlapY = Math.abs(minOverlap * minOverlapAxis.y);

            const direction = box2.position.sub(box1.position);
            const dotProduct = direction.x * minOverlapAxis.x + direction.y * minOverlapAxis.y;
            if (dotProduct < 0) {
                result.normal = new cc.Vec2(-minOverlapAxis.x, -minOverlapAxis.y);
            } else {
                result.normal = new cc.Vec2(minOverlapAxis.x, minOverlapAxis.y);
            }
        }
    }

    return true;
}
```

---

### 2. `CheckOBBCollision` — 노드 기반 OBB 충돌 감지

`cc.Node` 두 개를 받아 위치·크기·회전각을 기반으로 OBBBox를 생성한 뒤 `MatchingOBB`를 호출합니다.  
크기(`size`)를 직접 넘기지 않으면 노드의 `getContentSize()`를 사용합니다.

```typescript
public static CheckOBBCollision(
    node1: cc.Node,
    node2: cc.Node,
    size1?: cc.Size,
    size2?: cc.Size,
    result?: CollisionResult
): boolean {
    if (!node1 || !node2) return false;

    const box1 = new OBBBox(
        node1.getPosition(), node1Size.width, node1Size.height, node1.angle
    );
    const box2 = new OBBBox(
        node2.getPosition(), node2Size.width, node2Size.height, node2.angle
    );

    return CCcollision.MatchingOBB(box1, box2, result);
}
```

---

### 3. `GetNodeOBB` — 노드에서 OBBBox 생성

노드의 위치·크기·회전각을 기반으로 `OBBBox` 객체를 생성하여 반환합니다.

```typescript
public static GetNodeOBB(node: cc.Node, size?: cc.Size): OBBBox {
    if (!node) return new OBBBox(cc.Vec2.ZERO, 0, 0, 0);

    const nodeSize = size || node.getContentSize();
    return new OBBBox(
        node.getPosition(), nodeSize.width, nodeSize.height, node.angle
    );
}
```

---

### 4. `IsPointInOBB` — 포인트의 OBB 내부 포함 여부

포인트를 OBB의 로컬 좌표로 역회전 변환한 뒤 AABB 체크를 수행합니다.

```typescript
public static IsPointInOBB(obb: OBBBox, point: cc.Vec2): boolean {
    const rad = -obb.angle * Math.PI / 180;
    const cos = Math.cos(rad);
    const sin = Math.sin(rad);

    const dx = point.x - obb.position.x;
    const dy = point.y - obb.position.y;

    const localX = dx * cos - dy * sin;
    const localY = dx * sin + dy * cos;

    const halfWidth = obb.width * 0.5;
    const halfHeight = obb.height * 0.5;

    return localX >= -halfWidth && localX <= halfWidth &&
           localY >= -halfHeight && localY <= halfHeight;
}
```

---

### 5. `GetOBBIntersectionArea` — 교집합 면적 근사 계산

충돌이 없으면 `0`을 반환합니다.  
충돌 시 최소 겹침량과 박스 크기를 기반으로 교집합 면적을 **근사값**으로 계산합니다.  
(정확한 다각형 교집합 계산은 복잡하므로 근사 방식 사용)

```typescript
public static GetOBBIntersectionArea(box1: OBBBox, box2: OBBBox): number {
    const result = new CollisionResult();
    if (!CCcollision.MatchingOBB(box1, box2, result)) return 0;

    const overlap = result.overlap;
    const area1 = box1.width * box1.height;
    const area2 = box2.width * box2.height;
    const minArea = Math.min(area1, area2);

    const minDim1 = Math.min(box1.width, box1.height);
    const minDim2 = Math.min(box2.width, box2.height);
    const avgMinDim = (minDim1 + minDim2) * 0.5;

    const overlapRatio = Math.min(overlap / avgMinDim, 1.0);
    return minArea * overlapRatio * overlapRatio;
}
```

---

### 6. `CheckOBBAreaOverlap` — 면적 비율 기반 겹침 판정

교집합 면적이 box2(카드) 면적의 `threshold` 이상이면 `true`를 반환합니다.  
기본 임계값은 `0.4` (40%)입니다.  
주로 **드래그 선택** 판정에 사용합니다.

```typescript
public static CheckOBBAreaOverlap(
    box1: OBBBox,  // 드래그 박스
    box2: OBBBox,  // 카드
    threshold: number = 0.4
): boolean {
    const intersectionArea = CCcollision.GetOBBIntersectionArea(box1, box2);
    const box2Area = box2.width * box2.height;

    if (box2Area === 0) return false;

    const overlapRatio = intersectionArea / box2Area;
    return overlapRatio >= threshold;
}
```

---

## 착시 문제 요약

| 조건 | 결과 |
|---|---|
| 층(layer) 값이 같은 두 카드가 충돌 판정 | 아래로 판단된 카드가 `facedown` 처리됨 |
| 플레이어 시점 | 카드가 잘못 배치된 것처럼 보이는 착시 발생 |
| 조치 방향 | 해당 맵을 라이브 서비스에서 제거 |
