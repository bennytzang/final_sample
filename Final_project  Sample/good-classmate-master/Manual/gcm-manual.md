# Good Classmate APP

## 0. Github

https://github.com/CodeMercs/good-classmate


## Idea

生活的目的除了讓自己能安適與愉快的享受快樂的生活品質之外，在心靈上的滿足是人們生活的主要指標，所以人際之間的互動在生活中扮演著重要角色，在人們的互動中，常會發生一些金錢往來，看似小事情的金錢往來，但常因人們的忙碌與疏忽或健忘，經由常時間的日積月累，可能會產生大事情或不良影響，甚至自己的人格信用。所以本設計的目標是為了解決生活的上的問題，舉例而言：當你跟 "好同學"、"好同事"、"好朋友"、"好姊妹"、"好哥們" ，一起出門去吃飯，通常會遇到自己臨時手頭現金不足，跟身旁人借的問題，雖然是小筆的金額，但是常因日久疏忽忘了償還，對方要追回欠款，卻又怕因小錢而傷感情，所以有了「好同學 APP 」(good classmate APP)貼心的設計，真對使用者容易遺忘的事情，尤其是個人金錢往來的向目，做一個貼心的小提醒。


## Remark

類以似記帳的方式所做得個人備忘錄，內容將個人紀錄所欠金額、欠款日期、所欠的對象、還款期限、還款日期、還款提醒等訊息。常言道：「欠錢還錢，再借不難。」我們在日常生活中個人的「信用」非常的重要，有了「好同學 APP 」的協助，讓我們在日常生活中的金錢往來與借貸方面，可以周全而萬無一失的運作，這套設計可說是生活上的金錢「小管家」，也是平日金錢消費管理的好幫手。


## 3. LICENSE

[GNU General Public License v3.0](https://github.com/CodeMercs/good-classmate/blob/master/LICENSE)


## 4. UI 概念圖

### (1) 初始畫面

初始畫面為空白，有可以新增資料的 Button。

![](https://raw.githubusercontent.com/CodeMercs/good-classmate/master/Image/UI1.png)


### (2) 新增欠款資料

新增資料頁面。

![](https://raw.githubusercontent.com/CodeMercs/good-classmate/master/Image/UI3.png)


### (3) 欠款與還款時間紀錄

欠款時間紀錄與預期還款的部分分為 年、月、日、時、分、秒， 若使用者沒輸入年、月、日，則自動補上系統時間。

![](https://raw.githubusercontent.com/CodeMercs/good-classmate/master/Image/UI4.png)


### (4) 金額輸入

金額則為數字的文字輸入。


### (5) 標籤對象

可以設定預定的對象標籤。

![](https://raw.githubusercontent.com/CodeMercs/good-classmate/master/Image/UI5.png)


### (6) 提醒時間

提醒時間為欠款時間日與預期還款日間的設定，使用者可以決定在剩餘多少時間時進行提醒。

![](https://raw.githubusercontent.com/CodeMercs/good-classmate/master/Image/UI6.png)


### (7) 完成紀錄

完成畫面呈現。

![](https://raw.githubusercontent.com/CodeMercs/good-classmate/master/Image/UI2.png)


## 5. 利害關係人表

|     利害關係人     |  目標  |
| :---------------: | :-----------: |
|               使用者             |      記帳      |
|             苦主            |      收錢      |


## 6. 事件表

|     事件     |  案例  |
| :---------------: | :-----------: |
|               使用者             |      記帳、查帳、提醒、標籤      |


## 7. 使用案例

### (1) 刪除記帳

|  使用者 | 刪除記帳 |
| :---------------: | :-----------: |
|  行為者  | 使用者 |
|  目標  | 讓使用者刪除記錄 |
|  前提  | 還款完成，使用者可以刪除記帳 |
|  結束  | 刪除記帳成功 |
|  系列事件  |  正常程序  |
|  步驟 1  | 刪除記帳 |
|  步驟 2  | 送出 |
|  步驟 3  | 顯示刪除記帳 |


### (2) 刪除標籤

|  使用者 | 刪除標籤 |
| :---------------: | :-----------: |
|  行為者  | 使用者 |
|  目標  | 使用者刪除欠款對象的標籤 |
|  前提  | 使用者有刪除標籤的需要 |
|  結束  | 刪除標籤的行為成功 |
|  系列事件  |  正常程序  |
|  步驟 1  | 刪除標籤 |
|  步驟 2  | 送出 |
|  步驟 3  | 刪除標籤成功 |


### (3) 提醒時間

|  使用者 | 提醒時間 |
| :---------------: | :-----------: |
|  行為者  | 使用者 |
|  目標  | 提醒使用者還款的時間 |
|  前提  | 使用者還款時間設定到期 |
|  結束  | 提醒訊息出現 |
|  系列事件  |  正常程序  |
|  步驟 1  | 設定提醒時間 |
|  步驟 2  | 送出 |
|  步驟 3  | 顯示訊息 |


### (4) 新增標籤

|  使用者 | 新增標籤 |
| :---------------: | :-----------: |
|  行為者  | 使用者 |
|  目標  | 新增欠款人標籤資訊 |
|  前提  | 使用者要設定常用欠款人資訊標籤 |
|  結束  | 新增成功 |
|  系列事件  |  正常程序  |
|  步驟 1  | 新增標籤 |
|  步驟 2  | 送出 |
|  步驟 3  | 顯示標籤成功 |


### (5) 查閱記帳

|  使用者 | 查閱記帳 |
| :---------------: | :-----------: |
|  行為者  | 使用者 |
|  目標  | 使用者查閱記帳 |
|  前提  | 使用者檢視所有記帳的記錄 |
|  結束  | 查閱成功 |
|  系列事件  |  正常程序  |
|  步驟 1  | 查閱記帳 |
|  步驟 2  | 顯示正常記帳 |


### (6) 新增記帳

|  使用者 | 新增記帳 |
| :---------------: | :-----------: |
|  行為者  | 使用者 |
|  目標  | 使用者進行記帳 |
|  前提  | 使用者有記帳的需求 |
|  結束  | 記帳成功 |
|  系列事件  |  正常程序  |
|  步驟 1  | 進入記帳 |
|  步驟 2  | 新增記帳明細 |
|  步驟 3  | 送出 |
|  步驟 4  | 顯示記帳 |


## 8. 使用案例圖

![](https://raw.githubusercontent.com/CodeMercs/good-classmate/master/Image/UC1.png)


## 9. 活動圖

### (1) 刪帳活動圖

![](https://raw.githubusercontent.com/CodeMercs/good-classmate/master/Image/ACT1.png)


### (2) 刪除標籤活動圖

![](https://raw.githubusercontent.com/CodeMercs/good-classmate/master/Image/ACT2.png)


### (3) 提醒時間活動圖

![](https://raw.githubusercontent.com/CodeMercs/good-classmate/master/Image/ACT3.png)


### (4) 新增標籤活動圖

![](https://raw.githubusercontent.com/CodeMercs/good-classmate/master/Image/ACT4.png)


### (5) 查帳活動圖

![](https://raw.githubusercontent.com/CodeMercs/good-classmate/master/Image/ACT5.png)


### (6) 記帳活動圖

![](https://raw.githubusercontent.com/CodeMercs/good-classmate/master/Image/ACT6.png)


## 10. 類別圖

![](https://raw.githubusercontent.com/CodeMercs/good-classmate/master/Image/C1.png)


## 11. 循序圖

### (1) 循序圖

![](https://raw.githubusercontent.com/CodeMercs/good-classmate/master/Image/SD1.png)


### (2) 循序圖

![](https://raw.githubusercontent.com/CodeMercs/good-classmate/master/Image/SD2.png)


### (3) 循序圖

![](https://raw.githubusercontent.com/CodeMercs/good-classmate/master/Image/SD3.png)


## 12. 資料詞彙

### (1) GCMTB

| 序號 | 鍵值 | 自動遞增 | 欄位 | 型態 | Null | 註解 | 範例 |
| :---------------: | :-----------: | :-----------: | :-----------: | :-----------: | :-----------: | :-----------: | :-----------: |
| 1 | PK | 是 | list_id | int(11) | 否 | 帳號編號 | 1 |
| 2 |    |    | money | int(11) | 否 | 金額數量 | 200 |
| 3 |    |    | name | varchar(30) | 否 | 姓名 | haoye |
| 4 |    |    | dateend | date | 否 | 還款日 | 2017-10-12 |
| 5 |    |    | datestart | date | 否 | 欠款日 | 2017-11-20 |
| 6 |    |    | wedt | varchar(30) | 否 | 還款對象標籤 | haoye |


## 13. ERD

![](https://raw.githubusercontent.com/CodeMercs/good-classmate/master/Image/ERD.png)




