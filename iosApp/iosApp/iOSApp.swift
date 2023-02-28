import SwiftUI
import shared

@main
struct iOSApp: App {
    let sdk = ApiClass()
    
	var body: some Scene {
		WindowGroup {
            ContentView(viewModel: .init(sdk: sdk))
		}
	}
}
