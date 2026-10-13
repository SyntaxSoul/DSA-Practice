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