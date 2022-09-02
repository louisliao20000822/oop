# Soft Design Report

**B07902094 廖榮運 資工三**

**Duty**

Card:

主要是儲存rank、suit，我有放一些function在裡面，例如compare、以及花色大小等等。

Player:

儲存name、手牌數量等訊息，以及排序手牌，檢查手牌是否為空、刪除、調換手牌等等函式。

Deck:

儲存一開始獲取的牌組。

Game:

操控遊戲的進行，每過完一個round都會執行一次。

Pattern:

所以pattern的rule和打出牌時所需要檢查的條件等等，我把檢查illegal instruction的步驟也放在裡面。

**Interacts**

Card:

其他classes要求卡牌的rank、suit或是要進行卡牌的比對時會用到。

Player:

主要會呼叫Card classes，其他classes在要求玩家名字、排序手牌、刪除調換手牌時會用到。

Game:

會呼叫到幾乎所有classes，只有main會呼叫這個classes。

Pattern:

因為要檢查許多條件以及出牌合不合法，所以要呼叫大部分的class，且code長度也最長。





