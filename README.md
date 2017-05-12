# DietXchange

## Description

My final project is a prototype application
to help people following the "Exchange Diet" system.
This particular system was developed
by the American Diabetes Association to help those
patients manage their diet and keep their carb intake low.
However, the system itself can be used by anyone. It works by breaking down foods into 6 categories and
assigning values (or "exchanges") to each category that
represent how much out of each category a person can eat.


Upon registering, users would be able to enter their desired calorie 
intake. Following this, these calories would be broken up 
up to meet their nutritional goals

For example, a person following a Mediterranean Diet 
(which emphasizes lean proteins, healthy fats, and whole grains) would want a nutrient breakdown goal of 40% carbohydrates,
25% protein, and 35% fat. For someone on 1400 calorie/day plan, 
560 calories would come from carbohydrates, equating to about 140 grams of carbohydrates

With this info, the application would present to you how many "servings" of each of the following categories you can have:

+ Starches
+ Fruits
+ Milk 
+ Vegetables
+ Protein
+ Fats

On a 1400 calorie plan, this would equal to:

Starches | Fruits | Milk | Vegetables | Protein | Fats
:---: | :---: | :---: | :---: | :---: | :---:
5 | 2 | 1 | 4 | 7 | 6

From there, for every meal (for this app, we will only consider the following meals: breakfast, lunch, dinner, and snacks), users may select from a simplified database of foods that contains allowed foods on the diet and the equivalent serving sizes. The app will keep track of how many of your servings in each category you have eaten and how many you have left for the day. Users can also "favorite" meals or foods, so that they can quickly select those items in the future.

Time permitting, the app will also include a feature for varying caloric goals (for ex, one week at 1400 calories and the next at 1800 calories, with the allowed servings in each category adjusted accordingly) and include a reporting feature of how the user has done over specific periods (by week, by month, by year, and the beginning of time). It'll also include the ability to create custom marconutrient percentages or calculate a recommended intake based on a user's personal information (weight, height, activity level, gender).

## Outside Sources:

Material Design Bootstrap: http://fezvrasta.github.io/bootstrap-material-design/bootstrap-elements.html

### Domains:

**1. Dieter**
- has recommended exchanges for each category
- has target calorie goal
- has favorites of foods (can be null)
- has many DayLogs

**2. DayLog**
- has category values allowed for the day
- helper functions for how many remaining of each category remainings
- has max 1 each of breakfast, lunch, dinner, snack
- has date
- has a user

**3. Meal**
- has type (breakfast, lunch, dinner, snack)
- has dayLog
- has user
- hasMany Foods

**4. Food**
- has category type: starch, fruit, milk, vegetable, protein, fat
- hasMany relationship with Meal
- has portion size
- has portion unit