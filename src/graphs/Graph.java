package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph
{

	public static void main(String[] args)
	{
		Graph g = new Graph();
		// Vertexes
		Vertex v1 = g.new Vertex("v1");
		Vertex v2 = g.new Vertex("v2");
		Vertex v3 = g.new Vertex("v3");
		// Edges
		v1.addEdge(g.new Edge(v2, 1));
		v2.addEdge(g.new Edge(v3, 1));
		// Graph
		g.vertexes.addAll(Arrays.asList(v1, v2, v3));
		g.toString();
	}

	List<Vertex> vertexes;

	public Graph()
	{
		this.vertexes = new ArrayList<>();
	}

	public Vertex getVertex(String startName)
	{
		return this.vertexes.stream().filter(v -> v.name.equals(startName)).findAny()
			.orElseThrow(() -> new IllegalStateException("Vertex " + startName + " does not exist in this graph"));
	}

	public boolean isConnected()
	{
		for (Vertex start : this.vertexes)
		{
			this.unweighted(start.name);
			for (Vertex end : this.vertexes)
			{
				if (start == end)
				{
					continue;
				}
				if (end.prev == null) { return false; }
			}
		}
		return true;
	}

	public void resetVertexes()
	{
		this.vertexes.forEach(vertex -> vertex.reset());
	}

	@Override
	public String toString()
	{
		for (Vertex vertex : this.vertexes)
		{
			System.out.println("Vertex: " + vertex.name);
			for (Edge edge : vertex.edges)
			{
				System.out.println("Edge to " + edge.dest.name);
			}
		}
		return super.toString();
	}

	public void unweighted(String startName)
	{
		this.resetVertexes();
		Vertex start = this.getVertex(startName);
		Queue<Vertex> q = new LinkedList<>();
		q.add(start);
		start.dist = 0;
		while (!q.isEmpty())
		{
			Vertex v = q.remove();
			for (Edge e : v.edges)
			{
				Vertex dest = e.dest;
				double newDist = v.dist + 1;
				if (dest.prev == null || dest.dist > newDist)
				{
					dest.dist = newDist;
					dest.prev = v;
					q.add(dest);
				}
			}
		}
	}

	public void weighted(String startName)
	{
		this.resetVertexes();
		Vertex start = this.getVertex(startName);
		Queue<Vertex> q = new LinkedList<>();
		q.add(start);
		start.dist = 0;
		while (!q.isEmpty())
		{
			Vertex v = q.remove();
			for (Edge e : v.edges)
			{
				Vertex dest = e.dest;
				double newDist = v.dist + e.cost;
				if (dest.prev == null || dest.dist > newDist)
				{
					dest.dist = newDist;
					dest.prev = v;
					q.add(dest);
				}
			}
		}
	}

	class Edge
	{

		Vertex	dest;
		double	cost;

		public Edge(Vertex d, double c)
		{
			this.dest = d;
		}
	}

	class Vertex
	{

		String		name;
		List<Edge>	edges;
		double		dist;
		Vertex		prev;

		public Vertex(String name)
		{
			this.name = name;
			this.edges = new ArrayList<>();
		}

		public void reset()
		{
			this.dist = 0;
			this.prev = null;
		}

		void addEdge(Edge edge)
		{
			this.edges.add(edge);
		}
	}
}
