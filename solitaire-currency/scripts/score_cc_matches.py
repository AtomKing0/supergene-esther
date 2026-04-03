"""CC Localization 시트에 매칭 점수 + 제안 문구 열 추가
- Score(1-5): 매칭 정확도
- Suggested EN: 우리 명칭 + CC 설명 조합 제안 문구
- 미매칭 CC 키 중 우리 기능과 개념 일치하는 것도 신규 매핑으로 추가
"""
import gspread
from google.oauth2.service_account import Credentials

SPREADSHEET_ID = "1Z6VGkSOFydDcX74anwN2meFW_LNMPs-rVgy3FlAqYqk"
SCOPES = ["https://www.googleapis.com/auth/spreadsheets"]

creds = Credentials.from_service_account_file("pst-agent-187157cdb8b7.json", scopes=SCOPES)
gc = gspread.authorize(creds)
sh = gc.open_by_key(SPREADSHEET_ID)
ws = sh.worksheet("CC Localization")
rows = ws.get_all_values()
sheet_id = ws._properties["sheetId"]

# 헤더 확인 — 현재: Category|Key|EN|KO|Our Key|Our EN|Our KO|Match
# 추가할 열: Score(I=8) | Suggested EN(J=9)
NEW_COLS = ["Score", "Suggested EN"]
current_cols = 8  # A~H

# ── 1) 기존 매칭 행에 점수 + 제안 문구 정의 ────────────────────────────────────
# (cc_key, score, suggested_en)
# suggested_en = "" 이면 Our EN 그대로 사용 가능
SCORE_MAP = {
    # ★★★★★ Score 5 — 동일 기능, 텍스트 그대로 사용
    "Gameplay.CoinGift.Button":                    (5, ""),
    "Gameplay.Free":                               (5, ""),
    "General.EndGamePopup.BackButton":             (5, ""),
    "General.EndGamePopup.QuitButton":             (5, ""),
    "General.EndGamePopup.QuitTitle":              (5, ""),
    "General.EndGamePopup.Subtitle":               (5, ""),
    "General.MainScreen.CollectionsButton":        (5, ""),
    "General.MainScreen.Shop":                     (5, ""),
    "General.MainScreen.TournamentsButton":        (5, ""),
    "General.Menu.Settings":                       (5, ""),
    "General.PreBonusLevelPopup.PlayButton":       (5, ""),
    "General.PrelevelPopup.BoostersTitle":         (5, ""),
    "General.PrelevelPopup.Free":                  (5, ""),
    "General.PrelevelPopup.PlayButton":            (5, ""),
    "General.Settings.Title":                      (5, ""),
    "General.VictoryPopup.Button":                 (5, ""),
    "General.VictoryPopup.Rewards":                (5, ""),
    "General.VictoryPopup.Title":                  (5, ""),
    "General.text.Claim":                          (5, ""),
    "General.text.UnlockAtLvl":                    (5, ""),
    "Meta.DailyLoginCalendar.ClaimButton":         (5, ""),
    "Meta.DailyLoginCalendar.Missed":              (5, ""),
    "Meta.DailyLoginCalendar.Tomorrow":            (5, ""),
    "Meta.EOC.Finished.Button":                    (5, ""),
    "Meta.EOC.Main.Button":                        (5, ""),
    "Meta.SeasonPass.Claim":                       (5, ""),
    "Meta.Shop.BestValue":                         (5, ""),
    "Meta.Shop.MostPopular":                       (5, ""),
    "Meta.Shop.Title":                             (5, ""),
    "Meta.TeamEvent.Finished.ClaimAll":            (5, ""),
    "Meta.Teams.Error.Header":                     (5, ""),
    "Meta.Teams.Join.View":                        (5, ""),
    "Meta.Teams.LeavePopup.Back":                  (5, ""),
    "Meta.Teams.Profanity.Title":                  (5, ""),
    "Meta.TOF.ExitPopup.ButtonBack":               (5, ""),
    "Meta.TOF.ExitPopup.ButtonCashOut":            (5, ""),
    "Meta.TugOfCards.PlayButton":                  (5, ""),
    "Meta.WinStreak.FOMO.Button.Quit":             (5, ""),
    "General.Time.RemainingTime.DaysHours":        (5, ""),
    "General.Time.RemainingTime.Hours":            (5, ""),
    "General.Time.RemainingTime.HoursMinutes":     (5, ""),
    "General.Time.RemainingTime.Minutes":          (5, ""),
    "General.Time.RemainingTime.MinutesSeconds":   (5, ""),
    "General.Time.RemainingTime.Seconds":          (5, ""),
    "Meta.QuestPopup.MilestoneCompleted.Title":    (5, ""),
    "Meta.TeamEvent.StageCompleted":               (5, ""),
    "Meta.Tournament.MainScreen.Leaderbaord":      (5, ""),
    "Meta.CardBacks.Icon":                         (5, ""),
    "Meta.Collections.Title":                      (5, ""),
    "General.TermsOfService.Link2Text":            (5, ""),
    "Tutorials.Gameplay.Undo":                     (5, ""),  # 텍스트 거의 동일

    # ★★★★☆ Score 4 — 명칭만 교체하면 사용 가능
    "General.VictoryPopup.Level":                  (4, "Level {0}"),
    "General.PostcardCompleted.Completed":         (4, "Completed!"),
    "General.PostcardsGallery.Completed":          (4, "Completed!"),
    "General.text.Completed":                      (4, "Completed!"),
    "Meta.EpisodeChase.Level":                     (4, "Level {0}"),
    "Meta.EpisodeRace.Level":                      (4, "Level {0}"),
    "Meta.DailyLoginCalendar.Title":               (4, "Daily gifts"),
    "Meta.DailyLoginStreak.Title":                 (4, "Daily gifts"),
    "Meta.DailyLoginStreak.Today":                 (4, "Today's gift!"),
    "Meta.EOC.ComingSoon":                         (4, "Coming soon"),
    "Meta.CardBacks.CardBackClassic02.Hint":       (4, "Coming soon"),
    "General.TeamsPopup.Subtitle":                 (4, "Coming soon"),
    "Meta.Quests.MilestoneDescription.BlackCards": (4, "Collect {0} black cards to get this reward."),
    "Meta.Quests.MilestoneDescription.RedCards":   (4, "Collect {0} red cards to get this reward."),
    "Meta.Quests.SubTitle.BlackCards":             (4, ""),
    "Meta.Quests.SubTitle.RedCards":               (4, ""),
    "Meta.Quests.TopReward":                       (4, "Top Reward"),
    "Meta.CascadingOffer.TopReward":               (4, "Top Reward"),
    "Meta.DailyLoginCalendar.TopReward":           (4, "Top Reward"),
    "General.Settings.ClientVersion":              (4, "Client Version:"),
    "Meta.PlayerProfile.Decks.Title":              (4, ""),
    "Gameplay.Texts.Rewards":                      (4, "Rewards:"),
    "Gameplay.CoinGift.RewardsText":               (4, "Rewards:"),
    "General.MainScreen.InviteButton":             (4, ""),
    "General.MainScreen.CrownCardsButton":         (4, ""),
    "Marketing.BrazeFriendshipSeason.Friends.email.mainctabutton":          (4, "Play now"),
    "Marketing.BrazeFriendshipSeason.Friends.email.subsection.ctabutton.teams": (4, "Play now"),
    "teams.email.button":                          (4, "Play now"),

    # ★★★☆☆ Score 3 — 우리 명칭 + CC 설명 조합 가능
    "General.Splashscreen.Text01":                 (3, "Tap a card that's one rank higher or lower than the bottom card. Clear all cards to win!"),
    "Gameplay.NotEnoughCoins.Title":               (3, "Not enough gold!"),
    "General.Ads.FailedToLoad":                    (3, ""),
    "General.Coins.Free":                          (3, ""),
    "General.Menu.Close":                          (3, ""),
    "General.Menu.EndGame":                        (3, ""),
    "General.RestartPopup.Title":                  (3, "Quit level?"),
    "Meta.PiggyBank.Title":                        (3, ""),
    "Meta.PlayerProfile.Title":                    (3, ""),
    "Postcards.Rio.Title2":                        (3, "Rio De Janeiro"),
    "Tutorials.Gameplay.Undo":                     (5, ""),

    # ★★☆☆☆ Score 2 — 참고 수준
    "General.TermsOfService.Button":               (2, "Accept"),
}

# ── 2) 신규 개념 매핑 — 이름 불일치지만 기능 동일한 CC 키 ──────────────────────
# (cc_key, cc_en, our_key, our_en, score, suggested_en)
NEW_CONCEPT_MAPS = [
    # 플러스 카드 ↔ CC PlusCard
    ("Tutorials.Tooltips.PlusCard.Description",
     "Tap this card when it's available to add extra cards to your deck.",
     "T_TUT_PLUS_CARD",
     "Plus Card! Match it to reveal extra cards.",
     4,
     "Tap the Plus Card to add extra cards to your deck!"),

    ("Tutorials.Tooltips.PlusCardTitle",
     "Extra Card",
     "T_TUT_PLUS_CARD",
     "Plus Card! Match it to reveal extra cards.",
     3,
     "Plus Card"),

    # 덱 드로우 ↔ CC Stockpile
    ("Tutorials.Gameplay.Stockpile",
     "There are no moves available. Tap the deck to draw a new card.",
     "T_TUT_DECK_DRAW",
     "No matching cards available. Tap the deck to draw a new card.",
     5,
     "No matching cards available. Tap the deck to draw a new card."),

    # 자물쇠 카드 ↔ CC Lock/Key
    ("Tutorials.Tooltips.Lock.Description",
     "Find a Key Card of the same color to clear the Lock Card.",
     "T_TIP_LOCK_CARD_DESC",
     "LOCK: Find a Key Card of the same color to unlock the Lock Card.",
     5,
     "Find a Key Card of the same color to unlock the Lock Card."),

    ("Tutorials.Tooltips.Key.Description",
     "Tap a Key Card to open a Lock Card of the same color.",
     "T_TIP_LOCK_CARD_DESC",
     "LOCK: Find a Key Card of the same color to unlock the Lock Card.",
     4,
     "Tap the Key Card to open the Lock Card of the same color."),

    ("Tutorials.Gameplay.LockKey01",
     "Find a Key Card on the board and tap it to unlock the Lock!",
     "T_TUT_LOCK_KEY",
     "Lock Card! Match the Key Card first.",
     4,
     "Find a Key Card on the board and tap it to unlock the Lock Card!"),

    # 러너 카드 ↔ CC Peel/ConveyorUp
    ("Tutorials.Tooltips.Peel.Description",
     "A Peel Card transforms into a new card every move.",
     "T_TUT_RUNNER_CARD",
     "Runner Card! Its number changes every turn.",
     3,
     "A Runner Card changes its number every turn — clear it before it changes again!"),

    ("Tutorials.Tooltips.ConveyorUp.Description",
     "Conveyor Up Cards rank up with each move until cleared.",
     "T_TUT_RUNNER_CARD",
     "Runner Card! Its number changes every turn.",
     2,
     "Runner Cards change rank with each move — time your match carefully!"),

    # 와일드카드 ↔ CC Fish
    ("Tutorials.Tooltips.WildCard.Description",
     "When uncovered, Fish Cards can be used at any time to clear other available cards.",
     "T_TUT_WILD_CARD",
     "Wild card unlocked! Match it with any card.",
     3,
     "Wild cards can be used at any time to match with any available card."),

    ("Tutorials.Gameplay.FishForStreak",
     "Fish can be played with any card on the board. Tap it to keep your streak going. Have a few on the house!",
     "T_TUT_WILD_CARD",
     "Wild card unlocked! Match it with any card.",
     3,
     "Wild cards can be played with any card on the board. Tap to keep your streak going. Enjoy a few on us!"),

    # 스트릭 ↔ CC Streaks
    ("Tutorials.Gameplay.Streaks01",
     "Clear multiple cards in a row to fill up your Streak Meter and earn rewards!",
     "T_TUT_STREAK",
     "Match cards in a row for Streak bonuses!",
     4,
     "Clear multiple cards in a row to fill up your Streak Meter and earn rewards!"),

    ("Tutorials.Gameplay.Streaks02",
     "Keep an eye on the Streak Meter to see what you can win!",
     "T_STREAK_INFO",
     "Match cards in a row to win a streak bonus!",
     4,
     "Keep matching cards in a row — fill the Streak Meter to win big!"),

    # 방치골드 ↔ CC CoinRefill
    ("Tutorials.Meta.CoinRefill.Text1",
     "Congratulations! You can now collect coins. Come back every 4 hours to collect bonus coins.",
     "T_TUT_IDLE_GOLD",
     "Idle Gold unlocked! Earn gold over time.",
     4,
     "Idle Gold unlocked! Come back every 4 hours to collect your bonus gold."),

    ("Tutorials.Meta.CoinRefill.Text3",
     "Claim your coins anytime, don't let them go to waste!",
     "T_TUT_IDLE_GOLD_COLLECT",
     "Idle gold is ready! Tap to collect!",
     4,
     "Your gold bonus is ready! Claim it now — don't let it go to waste!"),

    # 베팅 ↔ CC Betup
    ("Tutorials.Meta.Betup.Text1",
     "Look, you can multiply the rewards!",
     "T_TUT_BETTING_1",
     "Try betting! Increase rewards with x1 bet!",
     4,
     "Look, you can multiply your rewards! Tap the bet button to increase your stakes."),

    ("Tutorials.Meta.Betup.Text2",
     "Tap the multiplier button!",
     "T_TUT_BETTING_1",
     "Try betting! Increase rewards with x1 bet!",
     3,
     "Tap the bet button to start multiplying your rewards!"),

    ("Tutorials.Meta.Betup.Text4",
     "More stakes, more rewards.",
     "T_TUT_BETTING_2",
     "Betting x2 unlocked! Go for bigger rewards!",
     4,
     "More stakes, more rewards — go for x2!"),

    # 엑스트라 덱 ↔ CC ExtraCards
    ("Gameplay.Tutorial.ExtraCards",
     "You've unlocked the Extra Cards booster! Use it to add 2 cards to your stockpile. Here are some freebies. Tap to activate it!",
     "T_TUT_EXTRA_DECK",
     "Extra Deck unlocked! Add 5 more cards. First 3 are free!",
     4,
     "Extra Deck unlocked! Add more cards to your deck. First 3 are free — tap to activate!"),

    # 핵심 게임플레이 소개
    ("Tutorials.Gameplay.CoreGameplay01",
     "Welcome to Candy Crush Solitaire! Tap a card that's one rank higher or lower than the one at the bottom. Clear all cards to win.",
     "T_TUT_INGAME_INTRO",
     "Welcome to Solitaire! Tap a card that's one rank higher or lower than the bottom card. Clear all cards to win!",
     4,
     "Welcome to Solitaire Tripeaks! Tap a card that's one rank higher or lower than the bottom card. Clear all cards to win!"),

    # 토너먼트
    ("Tutorials.Meta.Tournament.Text1",
     "Welcome to the Solitaire Grand Cup! For the next weeks, you'll be going head-to-head with players from around the world, to win the Grand Prize!",
     "T_TOURNAMENT_DESC",
     "Claim your glory and royal treasures!",
     3,
     "Compete against players from around the world to claim glory and royal treasures!"),

    # 숍 해금
    ("Tutorials.Meta.ShopUnlocked",
     "Ahh the shop is now available! Visit the shop to get amazing boosters and more!",
     "T_TUT_SHOP",
     "The Shop is open! Let's take a look!",
     4,
     "The Shop is open! Get amazing boosters and more!"),

    # 일일 휠
    ("Tutorials.Meta.ShopFreebie",
     "Try your luck with this wheel! Earn sweet rewards every day.",
     "T_TUT_DAILY_WHEEL",
     "Daily Wheel unlocked! Spin daily for rewards!",
     4,
     "Daily Wheel unlocked! Try your luck and earn rewards every day!"),

    # 언두 리마인더
    ("Tutorials.Gameplay.UndoReminder",
     "Remember, tap Undo to reverse your last move!",
     "T_TUT_UNDO",
     "Undo reverses your last move. Enjoy 3 free on us!",
     4,
     "Undo reverses your last move — tap to go back!"),

    # 아이스 카드 — 유사 기믹 참고
    ("Tutorials.Tooltips.Liquorice.Description",
     "Remove the liquorice by clearing it with a card one rank higher or lower.",
     "T_TIP_ICE_CARD_DESC",
     "ICE: Break the ice layer first to free the card beneath. Match adjacent cards to crack the ice!",
     2,
     "Ice Cards have a layer that must be broken first. Match cards to crack the ice and free the card beneath!"),
]

# ── 3) 시트 읽기 — Key → row index 매핑 ──────────────────────────────────────
key_to_row = {}
for i, row in enumerate(rows):
    if len(row) > 1 and row[1] and not row[1].startswith("["):
        key_to_row[row[1]] = i

print(f"CC 시트: {len(rows)}행, 키 인덱스: {len(key_to_row)}개")

# ── 4) 열 확장 ────────────────────────────────────────────────────────────────
needed_cols = current_cols + len(NEW_COLS)
sh.batch_update({"requests": [{
    "updateSheetProperties": {
        "properties": {"sheetId": sheet_id, "gridProperties": {"columnCount": needed_cols}},
        "fields": "gridProperties.columnCount"
    }
}]})

# ── 5) 업데이트 데이터 생성 ───────────────────────────────────────────────────
def col_letter(n):
    result = ""
    while n >= 0:
        result = chr(n % 26 + ord('A')) + result
        n = n // 26 - 1
    return result

cell_data = []

# 헤더
for ci, name in enumerate(NEW_COLS):
    cell_data.append({"range": f"{col_letter(current_cols + ci)}1", "values": [[name]]})

# 기존 매칭 행에 점수 적용
scored = 0
for cc_key, (score, suggested) in SCORE_MAP.items():
    if cc_key not in key_to_row:
        continue
    ri = key_to_row[cc_key] + 1
    cell_data.append({"range": f"{col_letter(current_cols)}{ri}",   "values": [[score]]})
    cell_data.append({"range": f"{col_letter(current_cols+1)}{ri}", "values": [[suggested]]})
    scored += 1

print(f"기존 매칭 점수 적용: {scored}개")

# ── 6) 신규 개념 매핑 — 시트에서 해당 CC 키 행 찾아 덮어쓰기 ────────────────────
new_mapped = 0
for cc_key, cc_en, our_key, our_en, score, suggested in NEW_CONCEPT_MAPS:
    if cc_key not in key_to_row:
        continue
    ri = key_to_row[cc_key] + 1
    # Our Key~Match 열(E~H = index 4~7) + Score/Suggested
    cell_data.append({"range": f"E{ri}", "values": [[our_key]]})
    cell_data.append({"range": f"F{ri}", "values": [[our_en]]})
    cell_data.append({"range": f"G{ri}", "values": [[""]]})  # Our KO는 별도
    cell_data.append({"range": f"H{ri}", "values": [["개념매칭"]]})
    cell_data.append({"range": f"{col_letter(current_cols)}{ri}",   "values": [[score]]})
    cell_data.append({"range": f"{col_letter(current_cols+1)}{ri}", "values": [[suggested]]})
    new_mapped += 1

print(f"신규 개념 매핑: {new_mapped}개")

# ── 7) 배치 전송 ──────────────────────────────────────────────────────────────
CHUNK = 500
for i in range(0, len(cell_data), CHUNK):
    ws.batch_update(cell_data[i:i+CHUNK], value_input_option="USER_ENTERED")
    print(f"  업데이트 {min(i+CHUNK, len(cell_data))}/{len(cell_data)}")

# ── 8) 열 서식 ────────────────────────────────────────────────────────────────
blue_header = {"red": 0.18, "green": 0.47, "blue": 0.71}
requests = [
    # 헤더 서식
    {"repeatCell": {
        "range": {"sheetId": sheet_id, "startRowIndex": 0, "endRowIndex": 1,
                  "startColumnIndex": current_cols, "endColumnIndex": current_cols + 2},
        "cell": {"userEnteredFormat": {
            "backgroundColor": blue_header,
            "textFormat": {"bold": True, "foregroundColor": {"red": 1, "green": 1, "blue": 1}},
            "horizontalAlignment": "CENTER",
        }},
        "fields": "userEnteredFormat(backgroundColor,textFormat,horizontalAlignment)",
    }},
    # 개념매칭 행 하이라이트 (하늘색)
]

# 개념매칭 행 색상
light_blue = {"red": 0.68, "green": 0.85, "blue": 0.90}
for cc_key, *_ in NEW_CONCEPT_MAPS:
    if cc_key not in key_to_row:
        continue
    ri = key_to_row[cc_key]
    requests.append({"repeatCell": {
        "range": {"sheetId": sheet_id, "startRowIndex": ri, "endRowIndex": ri+1,
                  "startColumnIndex": 4, "endColumnIndex": current_cols + 2},
        "cell": {"userEnteredFormat": {"backgroundColor": light_blue}},
        "fields": "userEnteredFormat.backgroundColor",
    }})

# 열 너비
for ci, px in enumerate([60, 380]):
    requests.append({"updateDimensionProperties": {
        "range": {"sheetId": sheet_id, "dimension": "COLUMNS",
                  "startIndex": current_cols + ci, "endIndex": current_cols + ci + 1},
        "properties": {"pixelSize": px}, "fields": "pixelSize",
    }})

sh.batch_update({"requests": requests})
print(f"\n✅ 완료! 점수 {scored}개 + 개념매핑 {new_mapped}개")
print(f"https://docs.google.com/spreadsheets/d/{SPREADSHEET_ID}")
