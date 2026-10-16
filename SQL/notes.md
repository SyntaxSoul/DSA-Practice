## SQL-1757: Recyclable and Low Fat Products

[Solution](./SQL-1757-RecyclableAndLowFatProducts.sql)

Pattern:
- SELECT
- WHERE Filtering
- AND Operator

Mistakes:
- No major mistake in the final query.

Key Insights:
- `SELECT` specifies the columns to return.
- `WHERE` filters rows based on conditions.
- `AND` requires both conditions to be true.
- String values are conventionally written using single quotes in MySQL.
- Only products with both `low_fats = 'Y'` and `recyclable = 'Y'` should be returned.

Mental Model:
- Check each product row.
- If both conditions are true, include its `product_id`.
- If either condition is false, exclude the row.

Trigger:
- When multiple conditions must all be satisfied, use `AND`.
- When selecting specific columns from rows that meet conditions, use `SELECT` with `WHERE`.

Time: O(n)
Space: O(1) auxiliary

## SQL-584: Find Customer Referee

[Solution](./SQL-584-FindCustomerReferee.sql)

Pattern:
- SELECT
- WHERE Filtering
- NULL Handling
- OR Operator

Mistakes:
- The initial query used only `referee_id != 2`.
- This excludes rows where `referee_id` is `NULL`, because comparisons with `NULL` evaluate to unknown in SQL.

Key Insights:
- `!=` checks whether a value differs from another value.
- `NULL` must be checked using `IS NULL`, not `= NULL`.
- Use `OR referee_id IS NULL` to include customers without a referee.
- `OR` returns rows when either condition is true.

Mental Model:
- Include customers whose referee is not `2`.
- Also include customers whose referee is unknown (`NULL`).
- Exclude customers whose referee is exactly `2`.

Trigger:
- When filtering for values that differ from a specific value but missing values must also be included, use `!=` together with `OR ... IS NULL`.

Time: O(n)
Space: O(1) auxiliary

## SQL-1148: Article Views I

[Solution](./SQL-1148-ArticleViewsI.sql)

Pattern:
- SELECT
- WHERE Filtering
- DISTINCT
- ORDER BY
- Column Aliasing

Mistakes:
- Initially used `==` for equality instead of MySQL's `=`.
- Did not account for duplicate author IDs in the result.
- Needed `DISTINCT` to return each author ID only once.
- Needed `AS id` to match the required output column name.

Key Insights:
- `WHERE author_id = viewer_id` selects rows where authors viewed their own articles.
- `DISTINCT` removes duplicate values from the result.
- `AS id` renames the output column to `id`.
- `ORDER BY author_id ASC` sorts author IDs in ascending order.
- SQL does not remove duplicates automatically.

Mental Model:
- First, filter rows where the author and viewer are the same.
- Next, keep only unique author IDs.
- Rename the output column to `id`.
- Finally, sort the IDs in ascending order.

Trigger:
- When a SQL problem asks for unique results, think `DISTINCT`.
- When two columns must have equal values, use `=`.
- When the output requires a specific column name, use `AS`.
- When results must be sorted, use `ORDER BY`.

Time: O(n log n) typically, depending on the execution plan and indexes
Space: O(n) worst case for duplicate elimination and sorting

## SQL-1683: Invalid Tweets

[Solution](./SQL-1683-InvalidTweets.sql)

Pattern:
- SELECT
- WHERE Filtering
- String Functions
- Character Length

Mistakes:
- No major mistake in the final query.

Key Insights:
- `CHAR_LENGTH(content)` returns the number of characters in a string.
- `WHERE CHAR_LENGTH(content) > 15` filters tweets containing more than 15 characters.
- `CHAR_LENGTH()` is appropriate when the requirement is based on character count.
- `LENGTH()` counts bytes rather than characters in MySQL, which can differ for multibyte characters.

Mental Model:
- Examine each tweet's content.
- Count its characters using `CHAR_LENGTH()`.
- If the count exceeds 15, return its `tweet_id`.

Trigger:
- When a SQL problem imposes a character limit on a string, think `CHAR_LENGTH()`.
- When filtering rows based on a calculated condition, use `WHERE`.

Time: O(n × L)
Space: O(1) auxiliary

Where `n` is the number of tweets and `L` is the average content length.

## SQL-620: Not Boring Movies

[Solution](./SQL-620-NotBoringMovies.sql)

Pattern:
- SELECT
- WHERE Filtering
- Modulo Operator
- ORDER BY
- Logical Operators

Mistakes:
- No major mistake in the final query.

Key Insights:
- `id % 2 = 1` selects rows with odd IDs.
- `%` is the modulo operator, which returns the remainder after division.
- `description <> 'boring'` excludes rows where the description is `boring`.
- `<>` means "not equal to" in SQL.
- `AND` requires both conditions to be true.
- `ORDER BY rating DESC` sorts results by rating from highest to lowest.
- `SELECT *` returns all columns.

Mental Model:
- First, select movies with odd IDs.
- Exclude movies whose description is `boring`.
- Sort the remaining movies by rating in descending order.

Trigger:
- When filtering odd or even IDs, think modulo (`%`).
- When excluding a specific value, use `<>` or `!=`.
- When results must be sorted from highest to lowest, use `ORDER BY ... DESC`.

Time: O(n log n) typically, due to filtering and sorting
Space: O(n) worst case for sorting, depending on the execution plan