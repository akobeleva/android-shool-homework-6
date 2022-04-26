package com.example.homework6

data class Employee(
    val id: Long,
    val fullName: String,
    val photoUrl: Int,
    var isLiked: Boolean
) {
    companion object {
        fun getMockEmployees() = listOf(
            Employee(
                0,
                "Dwayane Jones",
                R.drawable.dwayne_johnson,
                false
            ),
            Employee(
                1,
                "Tom Cruise",
                R.drawable.tom_cruise,
                false

            ),
            Employee(
                2,
                "Emily Blunt",
                R.drawable.emily_blunt,
                false
            ),
            Employee(
                3,
                "Emilia Clarke",
                R.drawable.emilia_clarke,
                false
            ),
            Employee(
                4,
                "Rayan Reynolds",
                R.drawable.ryan_reynolds,
                false
            ),
            Employee(
                5,
                "Emma Stone",
                R.drawable.emma_stone,
                false
            ),
            Employee(
                6,
                "Robert John Downey Jr.",
                R.drawable.robert_downey_jr,
                false
            ),
            Employee(
                7,
                "Brad Pitt",
                R.drawable.brad_pitt,
                false
            ),
        )
    }
}
