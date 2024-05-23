package com.example.patterns.creational.convertor;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public abstract class Converter<Source, Destination> {

	private final Function<Source, Destination> toDestination;
	private final Function<Destination, Source> toSource;

	public Converter(final Function<Source, Destination> toDestination, final Function<Destination, Source> toSource) {
		this.toDestination = toDestination;
		this.toSource = toSource;
	}

	public final Destination toDestination(final Source source) {
		return toDestination.apply(source);
	}

	public final Source toSource(final Destination destination) {
		return toSource.apply(destination);
	}

	public final List<Destination> toDestinations(final Collection<Source> sources) {
		return sources.stream()
				.map(this::toDestination)
				.collect(Collectors.toList());
	}

	public final List<Source> toSources(final Collection<Destination> destinations) {
		return destinations.stream()
				.map(this::toSource)
				.collect(Collectors.toList());
	}
}