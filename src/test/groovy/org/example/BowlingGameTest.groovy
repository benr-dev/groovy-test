package org.example

import org.junit.Test
import static org.hamcrest.MatcherAssert.*
import static org.hamcrest.Matchers.*

class BowlingGameTest {
    @Test
    void when_gutterGame_then_zeroScore() {
        BowlingGame game = new BowlingGame()
        game.roll(0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0)
        assertThat(game.score(), equalTo(0))
    }

    @Test
    void when_all1sGame_then_scoreIs20() {
        BowlingGame game = new BowlingGame()
        game.roll(1,1, 1,1, 1,1, 1,1, 1,1, 1,1, 1,1, 1,1, 1,1, 1,1)
        assertThat(game.score(), equalTo(20))
    }

    @Test
    void when_aSpareThen3_then_scoreIs16() {
        BowlingGame game = new BowlingGame()
        game.roll(5,5, 3,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0)
        assertThat(game.score(), equalTo(16))
    }

    @Test
    void when_aStrikeThen3Then3_then_scoreIs22() {
        BowlingGame game = new BowlingGame()
        game.roll(10, 3,3, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0)
        assertThat(game.score(), equalTo(22))
    }

    @Test
    void when_maximumGame_then_scoreIs300() {
        BowlingGame game = new BowlingGame()
        game.roll(10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 )
        assertThat(game.score(), equalTo(300))
    }
}