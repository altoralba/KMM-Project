import SwiftUI
import shared

struct ContentView: View {
    let greeting = Greeting()
    let testing = TestFunc()
    
    let coffeeAPI = APIRequest()
    //let coffeeAPI = API.APIRequest()
    
    @State var orderName = []
    @State var greet = "Loading..."
    
    Text("hello edward!")
    
    func loadInfo(){
        coffeeAPI.orderInfo { result, error in
            if let result = result {
                for i in 1...result.data.count {
                    let current = i - 1
                    orderName.append("\(result.data[current].id): \(result.data[current].name)")
                }
                self.greet = "\(orderName)"
            }
            else if let error = error {
                greet = "Error: \(error)"
            }
        }
    }
    
	var body: some View {
        SwiftUI.Text(greet)
            .font(.title)
            .fontWeight(.bold)
            .foregroundColor(Color.green)
            .multilineTextAlignment(.center)
            .onAppear(){
            loadInfo()
        }
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
