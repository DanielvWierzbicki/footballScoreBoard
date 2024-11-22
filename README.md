### Football World Cup Score Board ###

## Overview
This is the implementation of a Football World Cup Score Board. It allows:
- Starting a match with two teams (home and away).
- Updating the score of an ongoing match.
- Finishing a match.
- Retrieving a summary of ongoing matches sorted by total score and most recent started one.

## Features
- In-memory storage using collections.
- Unit tests included.

## How to Run
1. Clone the repository.
2. Build the project using Gradle or other build tool.
3. Run the unit tests using `gradle test` or through the IDE.

## Assumptions
- Matches have unique team combinations.
- Scores must be non-negative.
- Summary is sorted by total score and most recent started one.