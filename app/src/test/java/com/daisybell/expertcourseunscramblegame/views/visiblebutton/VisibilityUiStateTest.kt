import android.view.View
import com.daisybell.expertcourseunscramblegame.views.visiblebutton.UpdateVisibility
import com.daisybell.expertcourseunscramblegame.views.visiblebutton.VisibilityUiState
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * @author DaisyBell on 24.10.2024
 */
class VisibilityUiStateTest {

    @Test
    fun testVisible() {
        val uiState = VisibilityUiState.Visible
        val sut = FakeVisibility()

        uiState.update(sut)

        assertEquals(View.VISIBLE, sut.visibility)
    }

    @Test
    fun testInvisible() {
        val uiState = VisibilityUiState.Invisible
        val sut = FakeVisibility()

        uiState.update(sut)

        assertEquals(View.INVISIBLE, sut.visibility)
    }

    @Test
    fun testGone() {
        val uiState = VisibilityUiState.Gone
        val sut = FakeVisibility()

        uiState.update(sut)

        assertEquals(View.GONE, sut.visibility)
    }

}

private class FakeVisibility : UpdateVisibility {

    override fun update(state: VisibilityUiState) {
        throw IllegalStateException("not used here")
    }

    var visibility: Int? = null

    override fun update(visibility: Int) {
        this.visibility = visibility
    }

}