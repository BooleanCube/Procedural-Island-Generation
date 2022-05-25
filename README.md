# Procedural-Island-Generation

Different Procedural Generation Algorithms that I could come up with to compare time complexity and results. Some look better than others but are slower, or faster. This was just done for testing out algorithms for procedural island generation for game development.

Ranked in terms of runtime:
- Adjacency Noise (Generates each row in O(1) runtime which makes the entire algorithm O(n))
- Outward Expansion (Grows an island starting from a given center)
- Flood Fill (Fills every node within the suggestive radius from the center similar to outward expansion)
- Brute Force (Manually traverses through the entire graph adding nodes within a certain radius from the center)
- Linear Bogo Pathfinding (Set random nodes around the map and the nodes will generate an island while randomly moving in directions towards the center)

Ranked from best looking (imo):
- Linear Bogo Pathfinding (has proper river generation and island generation and the shape also looks really nice)
- Outward Expansion (Has an overall amazing shape like the average naturally generated islands)
- Flood Fill (Looks like the average generated island except with random holes in it)
- Adjacency Noise (If perfected even more visually, it would lose its runtime performance advantage)
- Brute Force (Has a very unnatural feeling to it since we aren't really keeping a track of distance from center in the probabilities)

Credits to Latch for Brute Force algorithm
