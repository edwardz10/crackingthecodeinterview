package concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureSimpleSnippet {

	private static CompletableFuture<Integer> createCompletableFuture() {
		CompletableFuture<Integer> futureCount = CompletableFuture.supplyAsync(
				() -> {
					try {
						Thread.sleep(2000);
					} catch (InterruptedException ie) {}
					return 20;
				});

		return futureCount;
	}

	public static void main(String[] args) {
		long started = System.currentTimeMillis();
		CompletableFuture<Integer> futureCount = createCompletableFuture();
		System.out.println("Took " + (started - System.currentTimeMillis()) + " milliseconds");

		try {
			int count = futureCount.get();
            System.out.println("CompletableFuture took " + (started - System.currentTimeMillis()) + " milliseconds" );
		} catch (InterruptedException | ExecutionException ee) {}
	}
}
