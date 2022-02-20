public class ChessboardTest {

	public static void main(String[] args) throws NoSuchFieldException, InterruptedException {
		// TODO Auto-generated method stub
		Chessboard cb = new Chessboard();

		Chessboard.Chesspiece[] pieces = new Chessboard.Chesspiece[] {
				cb.new Pawn  ('w'),	// Changing from white to black changes the walking direction
				cb.new Rook  ('b'),
				cb.new Queen ('w'),
				cb.new Bishop('w'),
				cb.new King  ('b'),
				cb.new Knight('w')
		};

		for (int i = 0; i < pieces.length; i++) {
			pieces[i].moveToRandom();
			pieces[i].markReachableFields();
			System.out.println(cb);
			Thread.sleep(1 * 1000);
			pieces[i].unmarkReachableFields();
			pieces[i].moveOut();


		}
		System.out.println("Done!");
	}

}
