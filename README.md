# DietXchange

## Description

My final project will be a web application that helps people following a Mediterranean Diet. This particular diet emphasizes lean proteins, healthy fats, and whole grains with a nutrient macro breakdown goal of 40% carbohydrates, 25% protein, and 35% grams.

Upon registering, users can enter their desired calorie intake. Following this, it'll break those calories up to meet the previously mentioned goals (for example, on a 1400 calorie plan, 560 calories would come from carbohydrates, equating to about 140 grams of carbohydrates).

From the breakdown of calories you're allowed, the application will present to you how many "servings" of each of the following categories you can have:

+ Starches
+ Fruits
+ Milk 
+ Vegetables
+ Protein
+ Fats

(For reference, each of these categories comes from the Diabetic Exchange List, a substitution-based meal plan frequently used to help those managing diabetes).

On a 1400 calorie plan, this would equal to:

Starches | Fruits | Milk | Vegetables | Protein | Fats
:---: | :---: | :---: | :---: | :---: | :---:
5 | 2 | 1 | 4 | 7 | 6

From there, for every meal (for this app, we will only consider the following meals: breakfast, lunch, dinner, and snacks), users may select from a simplified database of foods that contains allowed foods on the diet and the equivalent serving sizes. The app will keep track of how many of your servings in each category you have eaten and how many you have left for the day. Users can also "favorite" meals or foods, so that they can quickly select those items in the future.

Time permitting, the app will also include a feature for varying caloric goals (for ex, one week at 1400 calories and the next at 1800 calories, with the allowed servings in each category adjusted accordingly) and include a reporting feature of how the user has done over specific periods (by week, by month, by year, and the beginning of time). It'll also include the ability to create custom marconutrient percentages or calculate a recommended intake based on a user's personal information (weight, height, activity level, gender).

## Outline

### Domains:

**1. User**
- has food recommendations for each category (starch, fruit, milk, vegetable, protein, fat)
- has target calorie goal
- has favorites of foods (can be null)
- has many DayLogs

**2. DayLog**
- has category values allowed for the day
- helper functions for how many remaining of each category remainings
- has max 1 each of breakfast, lunch, dinner, snack
- has date
- has a user

**3. Breakfast** - has daylog, has user, hasMany foods (foods can be null for all meal types)

**4. Lunch** - - has daylog, has user, hasMany foods

**5. Dinner** - - has daylog, has user, hasMany foods

**6. Snack** - has daylog, has user, hasMany foods

>(Considered making these one Meal domain with different types, but decided it be easier for retrieval and categorizing purposes if they were all different domains)

**7. Food**
- has category type: starch, fruit, milk, vegetable, protein, fat
- has contants for food type value in calories and grams
- belongs to Breakfast/Lunch/Dinner/Snack
- has favorite flag
- has portion size

### Food database
Each item has 
- item name
- has food type(s)
- has portion size
- possibly JSON formatted? Ideas welcome
