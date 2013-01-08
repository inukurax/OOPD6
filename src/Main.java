import spreadsheet.*;

import spreadsheet.arithmetic.*;
import spreadsheet.textual.*;
import spreadsheet.logical.*;

class Main {

  public static void main(String[] _) throws CycleException {

    System.out.println(new Position(5,5).getDescription());

    final Spreadsheet spreadsheet = new Spreadsheet();
    spreadsheet.set(new Position(0,0),
      new Concat(new Text("hello, "), new Add(new Int(4), new Int(5))));

    spreadsheet.set(new Position(2,3), new Int(4));
    spreadsheet.set(new Position(3,2), new Int(2));
    spreadsheet.set(new Position(2,5), new Int(8));

    spreadsheet.set(new Position(10, 1),
      new Reference(spreadsheet, new Position(10, 2)));
    spreadsheet.set(new Position(10, 2),
      new Reference(spreadsheet, new Position(10, 3)));
    spreadsheet.set(new Position(10, 3),
      new Reference(spreadsheet, new Position(10, 1)));

    spreadsheet.get(new Position(10, 1)).checkAcyclic(null);

  }

}
