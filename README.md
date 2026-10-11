# WordBlast
A Text based word puzzle where players go one by one racing the clock to prevent a Word Blast, where spore clouds created by corrupted letters spread too far and take over if the player is unable to come up with a word in time.

## Starting/How to Run
- Running the code and starting the game
- Once the code is running, users will select the number of players playing the game and each will choose a player name for themselves.

## How to Play
 - The order of each players turn is randomized. 
 - A player's turn begins by pressing the spacebar, generating either two or three random characters and starting the clock, which will get faster after every round. 
 - The player will then journey into their minds to bring forth a word containing the two or three characters exactly as they appear in front of them to purify the corrupted characters (Ex. for generated characters "ch," words that satisfy include "CHameleon," "WatCH," or "PatCHes"). 
 - A valid word will give the player points and remove it from the available word collection. The game will then loop and create a new sequence of characters for each turn. 
 - First player to x points clears the forest of spore clouds and wins the game.

## Scoring
Every letter in the word, including those that show up more than once and the generated ones, give points.
Standard Scrabble-style letter scoring system:
- Every a, e, i, o, u, l, n, s, t, and r are worth 1 point
- Every d and g are worth 2 points
- Every b, c, m, and p are worth 3 points
- Every f, h, v, w, and y are worth 4 points
- Every k is worth 5 points
- Every j and x are worth 8 points
- Every q and z are worth 10 points
- No word results in 0 points

## System Features
- Validates player entered English words by comparing to a local words.txt dictionary.
- Rejects words that are not in the meantioned dictionary and have already been used
- Generates connected characters that are tested and proven to be contained in actual words.

## Future Improvements
- Voice activated gameplay
- Multi client web compatibility
- Polished front end