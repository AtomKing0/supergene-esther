---
agent: 11_translation
mode: translation
scope: T_PROMO_7DAYS 신규번역 (5개 키)
executed: 2026-04-27T11:18:00+09:00
status: complete
keys_translated: 5
consistency_issues_found: 0
dangerous_chars_found: 1
handoff_to: 07_sheet_modifier
---

## 특수문자 처리

| 키 | 원본 | 치환 | 사유 |
|---|---|---|---|
| T_PROMO_7DAYS_DESC_2 | `—` (U+2014 em-dash) | `-` (hyphen) | 금지 문자 규칙 |

## 번역 결과

| key | en | kr | ar | es | pt | id | ru | fr | th |
|-----|----|----|----|----|----|----|----|----|-----|
| T_PROMO_7DAYS_TITLE | 7-Day Lucky Rewards | 7일 행운 보상 | مكافآت الحظ لـ 7 أيام | Recompensas de 7 días de suerte | Recompensas sortudas de 7 dias | Hadiah Keberuntungan 7 Hari | 7-дневные счастливые награды | Récompenses chanceuses sur 7 jours | รางวัลโชคดี 7 วัน |
| T_PROMO_7DAYS_DESC_1 | Come 7 days in April and get ₩70! | 4월 7일 동안 접속하고 ₩70을 받으세요! | احضر 7 أيام في أبريل واحصل على ₩70! | ¡Entra 7 días en abril y obtén ₩70! | Venha 7 dias em abril e ganhe ₩70! | Datang 7 hari di bulan April dan dapatkan ₩70! | Приходи 7 дней в апреле и получи ₩70! | Venez 7 jours en avril et obtenez ₩70! | มา 7 วันในเดือนเมษายนและรับ ₩70! |
| T_PROMO_7DAYS_DESC_2 | Skip a day? No worries - reward stays! | 하루 빠졌나요? 걱정 마세요 - 보상은 유지돼요! | فاتك يوم؟ لا قلق - المكافأة تبقى! | ¿Faltaste un día? No te preocupes - ¡el premio sigue ahí! | Perdeu um dia? Sem problemas - a recompensa fica! | Lewat sehari? Jangan khawatir - hadiahnya tetap ada! | Пропустил день? Не волнуйся - награда остается! | Vous avez manqué un jour? Pas de souci - la récompense reste! | ขาดวัน? ไม่ต้องกังวล - รางวัลยังอยู่! |
| T_PROMO_7DAYS_KRW | {0}KRW | {0}KRW | {0}KRW | {0}KRW | {0}KRW | {0}KRW | {0}KRW | {0}KRW | {0}KRW |
| T_PROMO_7DAYS_DESC_3 | Ends early if points run out (by Apr 30) | 포인트 소진 시 조기 종료 (4월 30일까지) | ينتهي مبكرًا إذا نفدت النقاط (بحلول 30 أبريل) | Termina antes si se agotan los puntos (hasta el 30 de abril) | Termina cedo se os pontos acabarem (até 30 de abril) | Berakhir lebih awal jika poin habis (hingga 30 April) | Завершается досрочно при исчерпании очков (до 30 апреля) | Se termine tot si les points sont epuises (avant le 30 avril) | สิ้นสุดก่อนกำหนดหากคะแนนหมด (ภายใน 30 เมษายน) |

## 페어 키 참조
해당 없음 (신규 프로모 이벤트 전용 키)

## 특수문자 검증 결과
- em-dash 1건 치환 완료 (DESC_2)
- NBSP, straight quote, en-dash, zero-width 문자: 0건
- 검증 통과

---

## 07_sheet_modifier 인계 사항

- 대상 시트: `string_code` (에이전트 시트)
- 작업 유형: 신규 행 5개 추가 (append)
- 수정 컬럼: en, kr, ar, es, pt, id, ru, fr, th (9개 언어 전체)
- 하이라이트: 연두색 (신규 행 추가)
- 시트 직접 수정 금지 확인: 본 에이전트는 파일 저장만 수행, 시트 미수정
