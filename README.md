# Procedural-Island-Generation

Different Procedural Generation Algorithms that I could come up with to compare time complexity and results. Some look better than others but are slower, or faster. This was just done for testing out algorithms for procedural island generation for game development.

Ranked in terms of runtime:
- Outward Expansion (Grows an island starting from a given center)
- Brute Force (Manually traverses through the entire graph adding nodes within a certain radius from the center)
- Linear Bogo Pathfinding (Set random nodes around the map and the nodes will generate an island while randomly moving in directions towards the center)

Ranked from best looking (imo):
- Linear Bogo Pathfinding (has proper river generation and island generation and the shape also looks really nice)
- Outward Expansion (Has a nice shape for smaller sized graphs. it gets a little weird with larger graphs)
- Brute Force (same description as outward expansion)

Credits to Latch for help with Brute Force algorithm
