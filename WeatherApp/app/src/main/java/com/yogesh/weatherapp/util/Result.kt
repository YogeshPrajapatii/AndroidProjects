package com.yogesh.weatherapp.util

sealed class Result<out T> {
    object Idle : Result<Nothing>()
    object Loading : Result<Nothing>()
    data class Error(val message: String) : Result<Nothing>()
    data class Success<T>(val data: T) : Result<T>()

}

/* 📝 Code Breakdown – har ek word ka matlab
kotlin
Copy
Edit
package com.yogesh.weatherapp.util
✅ Ye bas package declaration hai. Ye file ka address bata raha hai.
Ye file kaha rakhi hai project me:
📁 com.yogesh.weatherapp.util

kotlin
Copy
Edit
sealed class Result<out T>
🔥 1. sealed class
sealed ka matlab hai “band class hierarchy”.

Iska fayda?

Sirf iske andar hi sub-classes ban sakti hain.

Iske bahar koi aur class inherit nahi kar sakta.

Compiler ko pata hota hai ki Result ke andar kaun-kaun se types hain.

👀 Example:

kotlin
Copy
Edit
Result.Idle
Result.Loading
Result.Error("msg")
Result.Success(data)
Compiler already in 4 types ko jaanta hai.

🔥 2. <out T>
Ye hai Generics:
T ka matlab Type parameter hai.

out T ka matlab hai ki:

Result class se hum T type ka data “return” karenge”.

Tu keh sakta hai:
Result kisi bhi type ka Success return kar sakta hai.

out ka use hai taaki ye sirf data produce kare (return kare), na ki consume.

👀 Example:

kotlin
Copy
Edit
Result.Success<String>("Hello")
Result.Success<Int>(123)
Iska T yahan String ya Int ban gaya.

🔥 3. Subclasses
(a) object Idle : Result<Nothing>()
Idle ek object hai.

Ye batata hai: "Koi API call abhi tak start nahi hui."

: Result<Nothing>()

Matlab Idle bhi ek Result hai.

Nothing ka matlab:
Is state me koi data nahi hai.

(b) object Loading : Result<Nothing>()
Loading ek object hai.

Ye batata hai: "API call chal rahi hai, data loading hai."

Nothing because: loading ke dauraan data nahi aaya hai.

(c) data class Error(val message: String) : Result<Nothing>()
Error ek data class hai.

Isme ek property hai: message: String

Ye batata hai error kya hua.

: Result<Nothing>()

Error hone par bhi koi valid data nahi hai.

👀 Example:

kotlin
Copy
Edit
Result.Error("Network failure")
(d) data class Success<T>(val data: T) : Result<T>()
Success ek data class hai.

Ye tab use hoti hai jab API call successful ho jaye.

Isme ek property hai:

data: T

Ye actual API response hai jo return karna hai.

👀 Example:

kotlin
Copy
Edit
Result.Success<WeatherResponse>(apiResponse)
Yahan T hai WeatherResponse

🔥 Summary of Subclasses
Subclass	When?	Data present?
Idle	Koi call start nahi hui.	❌ No data
Loading	Call chal rahi hai.	❌ No data
Error	Call fail ho gayi.	✅ Message
Success<T>	Call successful.	✅ Data of T

📦 Why in util?
Ye global state wrapper hai jo har API, DB call me reuse hoga.

Har ViewModel me ye state use hoga:

UI ko batane ke liye:

✅ Data aaya

🔄 Loading hai

❌ Error aaya

💤 Idle hai

📌 Flow Example
API Call se UI tak
1️⃣ Start:

kotlin
Copy
Edit
authViewModel.authState = Result.Loading
2️⃣ API success:

kotlin
Copy
Edit
authViewModel.authState = Result.Success(apiResponse)
3️⃣ API fail:

kotlin
Copy
Edit
authViewModel.authState = Result.Error("Server Down")
4️⃣ UI checks:

kotlin
Copy
Edit
when (authState) {
    is Result.Idle -> ShowNothing()
    is Result.Loading -> ShowLoader()
    is Result.Success -> ShowData(authState.data)
    is Result.Error -> ShowError(authState.message)
}
👑 Why It Returns Itself? (Your doubt)
✅ Tu bilkul sahi pakda bhai!
Ye khud hi return nahi kar raha, ye sub-classes ko Result ke andar rakhta hai.
Har sub-class Result ka ek type hai:

Idle : Result<Nothing>

Loading : Result<Nothing>

Error : Result<Nothing>

Success<T> : Result<T>

Matlab ye Result ka ek instance banate hain.

🚀 Why Needed in Clean Architecture?
✔ ViewModel se UI ko ek single state me data bhejne ke liye.
✔ Har API ka alag alag state manage karne ka tension khatam.
✔ UI me bas when (state) likho aur har state handle.

🧑‍💻 Beginner Analogy:
Soch:

📡 API call kar raha hu

🪧 Result ek signboard hai jo bolta hai:

"Loading hai"

"Success hua, ye data le"

"Error aaya, ye message le"

"Idle, abhi kuch nahi chal raha"

*/
