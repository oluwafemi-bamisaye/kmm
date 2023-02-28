import SwiftUI
import shared

struct ContentView: View {
    @ObservedObject private(set) var viewModel: ViewModel
    
	var body: some View {
        NavigationView {
            listView()
            .navigationBarTitle("Sample Entries")
        }
    }
    
    private func listView() -> AnyView {
            return AnyView(List(viewModel.entries!) { phone in
                Text("\(phone.api)\n\(phone.desc)\n\(phone.category)")
            })
    }
}

extension Entries : Identifiable { }
extension Input : Identifiable { }
extension ApiClass : Identifiable { }

extension ContentView {
    
    class ViewModel: ObservableObject {
        
        let sdk: ApiClass
        
        @Published var entries: [Entries]? = []
        
            init(sdk: ApiClass) {
                self.sdk = sdk
                self.loadLaunches()
            }

            func loadLaunches() {
                sdk.getEntries() { Input, error in
                    self.entries = Input?.list
                }
            }
        }
}
